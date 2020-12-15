
// ModbusApiTestDlg.cpp : ʵ���ļ�
//

#include "stdafx.h"
#include "ModbusApiTest.h"
#include "ModbusApiTestDlg.h"


#include "Hc_Modbus_Api.h"
#pragma comment(lib, "StandardModbusApi.lib")


#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// ����Ӧ�ó��򡰹��ڡ��˵���� CAboutDlg �Ի���

class CAboutDlg : public CDialog
{
public:
	CAboutDlg();

// �Ի�������
	enum { IDD = IDD_ABOUTBOX };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV ֧��

// ʵ��
protected:
	DECLARE_MESSAGE_MAP()
};

CAboutDlg::CAboutDlg() : CDialog(CAboutDlg::IDD)
{
}

void CAboutDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CAboutDlg, CDialog)
END_MESSAGE_MAP()


// CModbusApiTestDlg �Ի���




CModbusApiTestDlg::CModbusApiTestDlg(CWnd* pParent /*=NULL*/)
	: CDialog(CModbusApiTestDlg::IDD, pParent)
{
	m_hIcon = AfxGetApp()->LoadIcon(IDR_MAINFRAME);
}

void CModbusApiTestDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
}

BEGIN_MESSAGE_MAP(CModbusApiTestDlg, CDialog)
	ON_WM_SYSCOMMAND()
	ON_WM_PAINT()
	ON_WM_QUERYDRAGICON()
	//}}AFX_MSG_MAP
	ON_BN_CLICKED(IDC_BUTTON1, &CModbusApiTestDlg::OnBnClickedButton1)
	ON_BN_CLICKED(IDC_BUTTON3, &CModbusApiTestDlg::OnBnClickedButton3)
	ON_BN_CLICKED(IDC_BUTTON4, &CModbusApiTestDlg::OnBnClickedButton4)
	ON_BN_CLICKED(IDC_BUTTON2, &CModbusApiTestDlg::OnBnClickedButton2)
END_MESSAGE_MAP()


// CModbusApiTestDlg ��Ϣ�������

BOOL CModbusApiTestDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// ��������...���˵�����ӵ�ϵͳ�˵��С�

	// IDM_ABOUTBOX ������ϵͳ���Χ�ڡ�
	ASSERT((IDM_ABOUTBOX & 0xFFF0) == IDM_ABOUTBOX);
	ASSERT(IDM_ABOUTBOX < 0xF000);

	CMenu* pSysMenu = GetSystemMenu(FALSE);
	if (pSysMenu != NULL)
	{
		BOOL bNameValid;
		CString strAboutMenu;
		bNameValid = strAboutMenu.LoadString(IDS_ABOUTBOX);
		ASSERT(bNameValid);
		if (!strAboutMenu.IsEmpty())
		{
			pSysMenu->AppendMenu(MF_SEPARATOR);
			pSysMenu->AppendMenu(MF_STRING, IDM_ABOUTBOX, strAboutMenu);
		}
	}

	// ���ô˶Ի����ͼ�ꡣ��Ӧ�ó��������ڲ��ǶԻ���ʱ����ܽ��Զ�
	//  ִ�д˲���
	SetIcon(m_hIcon, TRUE);			// ���ô�ͼ��
	SetIcon(m_hIcon, FALSE);		// ����Сͼ��

	// TODO: �ڴ���Ӷ���ĳ�ʼ������

	return TRUE;  // ���ǽ��������õ��ؼ������򷵻� TRUE
}

void CModbusApiTestDlg::OnSysCommand(UINT nID, LPARAM lParam)
{
	if ((nID & 0xFFF0) == IDM_ABOUTBOX)
	{
		CAboutDlg dlgAbout;
		dlgAbout.DoModal();
	}
	else
	{
		CDialog::OnSysCommand(nID, lParam);
	}
}

// �����Ի��������С����ť������Ҫ����Ĵ���
//  �����Ƹ�ͼ�ꡣ����ʹ���ĵ�/��ͼģ�͵� MFC Ӧ�ó���
//  �⽫�ɿ���Զ���ɡ�

void CModbusApiTestDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // ���ڻ��Ƶ��豸������

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// ʹͼ���ڹ����������о���
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// ����ͼ��
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

//���û��϶���С������ʱϵͳ���ô˺���ȡ�ù��
//��ʾ��
HCURSOR CModbusApiTestDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}


void CModbusApiTestDlg::OnBnClickedButton1()
{
	// TODO: �ڴ���ӿؼ�֪ͨ����������
	int nNetId = 0;
	int nIpPort = 502;
	BOOL  bRet = Init_ETH_String ("10.44.52.239", nNetId, nIpPort);

	if (bRet)
	{
		AfxMessageBox(_T("���ӳɹ�"));
	} 
	else
	{
		AfxMessageBox(_T("����ʧ��"));
	}
}

void CModbusApiTestDlg::OnBnClickedButton3()
{
	// TODO: �ڴ���ӿؼ�֪ͨ����������

	//����ʾ��1����65534д��D100��
	{
		SoftElemType eType = REGI_H3U_DW;//�Ĵ�������
		int nStartAddr = 100;//�Ĵ�����ַ
		int nCount =1;//�Ĵ�������
		BYTE pValue[2];//������
		int nNetId = 0;//����id
		unsigned short nValue = 65534;

		//��Ҫд�����ݴ��뻺��������д
		memcpy(pValue,&nValue,sizeof(nValue));

		//����apiд����
		int nRet = H3u_Write_Soft_Elem(eType,nStartAddr,nCount, pValue,nNetId );

		if (nRet)
		{
			AfxMessageBox(_T("д�Ĵ����ɹ�"));
		} 
		else
		{
			AfxMessageBox(_T("д�Ĵ���ʧ��"));
		}
	}

	//����ʾ��2����Y5-Y14��λ
	{
		SoftElemType eType = REGI_H3U_Y;//�Ĵ�������
		int nStartAddr = 5;//�Ĵ�����ʼ��ַ
		int nCount =8;//�Ĵ�������
		BYTE pValue[8];//������
		int nNetId = 0;//����id

		//��Ҫд�����ݴ��뻺��������д
		pValue[0] = 1;//Y5
		pValue[1] = 1;//Y6
		pValue[2] = 1;//Y7
		pValue[3] = 1;//Y10
		pValue[4] = 1;//Y11
		pValue[5] = 1;//Y12
		pValue[6] = 1;//Y13
		pValue[7] = 1;//Y14

		//����apiд����
		int nRet = H3u_Write_Soft_Elem(eType,nStartAddr,nCount, pValue,nNetId );

		if (nRet)
		{
			AfxMessageBox(_T("д�Ĵ����ɹ�"));
		} 
		else
		{
			AfxMessageBox(_T("д�Ĵ���ʧ��"));
		}
	}

}

void CModbusApiTestDlg::OnBnClickedButton4()
{
	// TODO: �ڴ���ӿؼ�֪ͨ����������

	{
		SoftElemType eType = REGI_H3U_DW;
		int nStartAddr = 100;
		int nCount =1;
		BYTE pValue[2];
		int nNetId = 0;

		int nRet = H3u_Read_Soft_Elem(eType,nStartAddr,nCount, pValue,nNetId );
		unsigned short nValue;
		memcpy(&nValue,pValue,sizeof(nValue));
		if (nRet)
		{
			AfxMessageBox(_T("���Ĵ����ɹ�"));
		} 
		else
		{
			AfxMessageBox(_T("���Ĵ���ʧ��"));
		}
	}


	//����ʾ��2����Y5-Y13��λ
	{
		SoftElemType eType = REGI_H3U_Y;//�Ĵ�������
		int nStartAddr = 5;//�Ĵ�����ʼ��ַ
		int nCount = 7;//�Ĵ�������
		BYTE pValue[8];//������(Ҫ��8��������)
		int nNetId = 0;//����id
		BOOL y5,y6,y7,y10,y11,y12,y13;

		//����apiд����
		int nRet = H3u_Read_Soft_Elem(eType,nStartAddr,nCount, pValue,nNetId );
		
		y5 = pValue[0];//Y5
		y6 = pValue[1];//Y6
		y7 = pValue[2];//Y7
		y10 = pValue[3];//Y10
		y11 = pValue[4];//Y11
		y12 = pValue[5];//Y12
		y13 = pValue[6];//Y13
		      pValue[7];//

		if (nRet)
		{
			AfxMessageBox(_T("д�Ĵ����ɹ�"));
		} 
		else
		{
			AfxMessageBox(_T("д�Ĵ���ʧ��"));
		}
	}

}

void CModbusApiTestDlg::OnBnClickedButton2()
{
	// TODO: �ڴ���ӿؼ�֪ͨ����������
	int nNetId = 0;
	BOOL  bRet = Exit_ETH(nNetId);

	if (bRet)
	{
		AfxMessageBox(_T("���ӳɹ�"));
	} 
	else
	{
		AfxMessageBox(_T("����ʧ��"));
	}

}
