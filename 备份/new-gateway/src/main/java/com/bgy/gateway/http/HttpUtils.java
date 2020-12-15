package com.bgy.gateway.http;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/**
 * @author caijunwei
 * date 2020/12/3 16:38
 */
public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static final String DEFAULT_CHARSET = "utf-8";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_GET = "GET";
    public static final String CONTENT_ENCODING_GZIP = "gzip";

    private HttpUtils() {
    }

    public static HttpResponseEntity get(String requestUri) {
        return get(requestUri, HttpRequestEntity.create());
    }

    public static HttpResponseEntity get(String requestUri, HttpRequestEntity requestEntity) {
        HttpURLConnection conn = null;
        HttpResponseEntity rsp = null;

        try {
            String ctype = "application/json;charset=" + requestEntity.getCharset();
            String query = buildQuery(requestEntity.getTextParams(), requestEntity.getCharset());
            conn = getConnection(buildGetUrl(requestUri, query), METHOD_GET, ctype, requestEntity);
            rsp = getResponseAsResponseEntity(conn);
        } catch (Exception e) {
            logger.error("error", e);
            rsp = new HttpResponseEntity(400, e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return rsp;
    }

    public static HttpResponseEntity postJson(String requestUri, String json, String charset) {
        HttpURLConnection conn = null;
        OutputStream out = null;
        HttpResponseEntity rsp = null;

        try {
            String ctype = "application/json;charset=" + charset;
            conn = getConnection(new URL(requestUri), METHOD_POST, ctype, HttpRequestEntity.create().charset(charset));
            byte[] data = json.getBytes();
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            out = conn.getOutputStream();
            out.write(data);
            out.flush();
            rsp = getResponseAsResponseEntity(conn);
        } catch (IOException e) {
            rsp = new HttpResponseEntity(400, e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e2) {
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }

        return rsp;
    }

    public static HttpResponseEntity postJsonRequest(String requestUri, String json, String charset, HttpRequestEntity requestEntity) {
        HttpURLConnection conn = null;
        OutputStream out = null;
        HttpResponseEntity rsp = null;

        try {
            String ctype = "application/json;charset=" + charset;
            conn = getConnection(new URL(requestUri), METHOD_POST, ctype, requestEntity);
            byte[] data = json.getBytes();
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            out = conn.getOutputStream();
            out.write(data);
            out.flush();
            rsp = getResponseAsResponseEntity(conn);
        } catch (IOException e) {
            rsp = new HttpResponseEntity(400, e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e2) {
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }

        return rsp;
    }



    public static HttpResponseEntity post(String requestUri, HttpRequestEntity requestEntity) {
        HttpURLConnection conn = null;
        OutputStream out = null;
        String contextType = null;
        HttpResponseEntity rsp = null;

        try {
            if (requestEntity.getFileParams().isEmpty()) {
                contextType = "application/x-www-form-urlencoded;charset=" + requestEntity.getCharset();
                conn = getConnection(new URL(requestUri), METHOD_POST, contextType, requestEntity);

                String query = buildQuery(requestEntity.getTextParams(), requestEntity.getCharset());
                byte[] content = {};
                if (query != null) {
                    content = query.getBytes(requestEntity.getCharset());
                }
                conn.setRequestProperty("Content-Length", String.valueOf(content.length));
                out = conn.getOutputStream();

                out.write(content);
            } else {
                String boundary = String.valueOf(System.nanoTime()); // 随机分隔线
                contextType = "multipart/form-data;charset=" + requestEntity.getCharset() + ";boundary=" + boundary;
                conn = getConnection(new URL(requestUri), METHOD_POST, contextType, requestEntity);
                out = conn.getOutputStream();

                byte[] entryBoundaryBytes = ("\r\n--" + boundary + "\r\n").getBytes(requestEntity.getCharset());

                // 组装文本请求参数
                Set<Map.Entry<String, Object>> textEntrySet = requestEntity.getTextParams().entrySet();
                for (Map.Entry<String, Object> textEntry : textEntrySet) {
                    byte[] textBytes = getTextEntry(textEntry.getKey(), textEntry.getValue(), requestEntity.getCharset());
                    out.write(entryBoundaryBytes);
                    out.write(textBytes);
                }

                // 组装文件请求参数
                Set<Map.Entry<String, HttpRequestEntity.FileItem>> fileEntrySet = requestEntity.getFileParams().entrySet();
                for (Map.Entry<String, HttpRequestEntity.FileItem> fileEntry : fileEntrySet) {
                    HttpRequestEntity.FileItem fileItem = fileEntry.getValue();
                    if (fileItem.getContent() == null) {
                        continue;
                    }
                    byte[] fileBytes = getFileEntry(fileEntry.getKey(), fileItem.getFileName(), fileItem.getMimeType(), requestEntity.getCharset());
                    out.write(entryBoundaryBytes);
                    out.write(fileBytes);
                    out.write(fileItem.getContent());
                }

                // 添加请求结束标志
                byte[] endBoundaryBytes = ("\r\n--" + boundary + "--\r\n").getBytes(requestEntity.getCharset());
                out.write(endBoundaryBytes);
            }

            rsp = getResponseAsResponseEntity(conn);

        } catch (Exception e) {
            rsp = new HttpResponseEntity(400, e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e2) {
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rsp;
    }


    private static HttpURLConnection getConnection(URL url, String method, String contextType, HttpRequestEntity requestEntity) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Accept", "*/*");
        conn.setRequestProperty("Content-Type", contextType);
        conn.setConnectTimeout(requestEntity.getConnectTimeout());
        conn.setReadTimeout(requestEntity.getReadTimeout());
        if (!requestEntity.getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : requestEntity.getHeaders().entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (requestEntity.getBasicAuth() != null) {
            conn.setRequestProperty("Authorization", requestEntity.getBasicAuth().getEncodeBasicAuth());
        }
        return conn;
    }

    private static byte[] getTextEntry(String fieldName, Object fieldValue, String charset) throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\"\r\nContent-Type:text/plain\r\n\r\n");
        entry.append(fieldValue);
        return entry.toString().getBytes(charset);
    }

    private static byte[] getFileEntry(String fieldName, String fileName, String mimeType, String charset) throws IOException {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\";filename=\"");
        entry.append(fileName);
        entry.append("\"\r\nContent-Type:");
        entry.append(mimeType);
        entry.append("\r\n\r\n");
        return entry.toString().getBytes(charset);
    }

    private static URL buildGetUrl(String strUrl, String query) throws IOException {
        URL url = new URL(strUrl);
        if (StringUtils.isEmpty(query)) {
            return url;
        }

        if (StringUtils.isEmpty(url.getQuery())) {
            if (strUrl.endsWith("?")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "?" + query;
            }
        } else {
            if (strUrl.endsWith("&")) {
                strUrl = strUrl + query;
            } else {
                strUrl = strUrl + "&" + query;
            }
        }

        return new URL(strUrl);
    }

    public static String buildQuery(Map<String, Object> params, String charset) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }

        StringBuilder query = new StringBuilder();
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, Object> entry : entries) {
            String name = entry.getKey();
            String value = null;
            if (entry.getValue() != null) {
                if (entry.getValue() instanceof String) {
                    value = (String) entry.getValue();
                } else {
                    value = entry.getValue().toString();
                }
            }
            // 忽略参数名或参数值为空的参数
            if (!StringUtils.isAnyEmpty(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=").append(URLEncoder.encode(value, charset));
            }
        }

        return query.toString();
    }

    private static HttpResponseEntity getResponseAsResponseEntity(HttpURLConnection conn) throws IOException {
        HttpResponseEntity responseEntity = new HttpResponseEntity();
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();

        responseEntity.setStatusCode(conn.getResponseCode());
        if (es == null) {
            String contentEncoding = conn.getContentEncoding();
            if (CONTENT_ENCODING_GZIP.equalsIgnoreCase(contentEncoding)) {
                responseEntity.setBody(getStreamAsString(new GZIPInputStream(conn.getInputStream()), charset));
            } else {
                responseEntity.setBody(getStreamAsString(conn.getInputStream(), charset));
            }
        } else {
            String msg = getStreamAsString(es, charset);
            if (StringUtils.isEmpty(msg)) {
                responseEntity.setBody(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                responseEntity.setBody(msg);
            }
        }

        return responseEntity;
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            Reader reader = new InputStreamReader(stream, charset);
            StringBuilder response = new StringBuilder();

            final char[] buff = new char[1024];
            int read = 0;
            while ((read = reader.read(buff)) > 0) {
                response.append(buff, 0, read);
            }

            return response.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;

        if (!StringUtils.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }

        return charset;
    }

}
