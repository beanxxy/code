#if !defined(_HC_MODBUS_API_H_)
#define _HC_MODBUS_API_H_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include "Include.h"
#include <string>
using namespace std;
void strcount(string & s);



#ifdef PUBLIC_EXPORT
#define STANDARD_MODBUS_FUNC_EXPORT __declspec( dllexport )
#else
#define STANDARD_MODBUS_FUNC_EXPORT __declspec( dllimport )
#endif



/******************************************************************************
 1.�������� :������������	                  
 2.�� �� ֵ :TRUE �ɹ�  FALSE ʧ��
 3.��    �� : IpAddr:��̫��IP��ַ��
              nNetId:�������ӱ��,���ڱ���ǵڼ�����������,ȡֵ��Χ0~255,Ĭ��0 
			  IpPort:��̫���˿ں�,Ĭ��502(modbusTcpЭ��Ĭ�϶˿ں�Ϊ502)
 4.ע������ : 
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT BOOL Init_ETH(DWORD IpAddr,int nNetId = 0,int IpPort = 502);


/******************************************************************************
 1.�������� :������������	                  
 2.�� �� ֵ :TRUE �ɹ�  FALSE ʧ��
 3.��    �� : sIpAddr:��̫��IP��ַ��
              nNetId:�������ӱ��,���ڱ���ǵڼ�����������,ȡֵ��Χ0~255,Ĭ��0 
			  IpPort:��̫���˿ں�,Ĭ��502(modbusTcpЭ��Ĭ�϶˿ں�Ϊ502)
 4.ע������ : 
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT BOOL Init_ETH_String(char* pIpAddr,int nNetId = 0,int IpPort = 502);


/******************************************************************************
 1.�������� :�ر���������                  
 2.�� �� ֵ :TRUE �ɹ�  FALSE ʧ��
 3.��    �� : nNetId:�������ӱ��,��Init_ETH�������õ�IDһ��
 4.ע������ : 
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT BOOL Exit_ETH(int nNetId = 0 );


/******************************************************************************
 1.�������� :���ó�ʱʱ�䣬            
 2.�� �� ֵ :TRUE �ɹ�  FALSE ʧ��
 3.��    �� : nNetId:�������ӱ��,��Init_ETH�������õ�IDһ��
 4.ע������ : �ڽ�������ǰ���ã������������ǰû�е��ã�Ĭ�ϳ�ʱʱ��Ϊ500ms
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT BOOL Set_ETH_TimeOut(int nTime,int nNetId = 0);


/******************************************************************************
 1.�������� :������ʱʱ��           
 2.�� �� ֵ :TRUE �ɹ�  FALSE ʧ��
 3.��    �� : nNetId:�������ӱ��,��Init_ETH�������õ�IDһ��
 4.ע������ : ������Ҫ��ʱ�ظ��ĳ��ϣ�û����Ҫ���Բ�����
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT BOOL Set_ETH_Delay(int nTime,int nNetId = 0);


/******************************************************************************
 1.�������� : дH3u��Ԫ��
 2.�� �� ֵ :1 �ɹ�  0 ʧ��
 3.��    �� : nNetId:�������ӱ��
			  eType����Ԫ������  
				  REGI_H3U_Y    = 0x20,     //YԪ���Ķ���	
				  REGI_H3U_X    = 0x21,		//XԪ���Ķ���							
				  REGI_H3U_S    = 0x22,		//SԪ���Ķ���				
				  REGI_H3U_M    = 0x23,		//MԪ���Ķ���							
				  REGI_H3U_TB   = 0x24,		//TλԪ���Ķ���				
				  REGI_H3U_TW   = 0x25,		//T��Ԫ���Ķ���				
				  REGI_H3U_CB   = 0x26,		//CλԪ���Ķ���				
				  REGI_H3U_CW   = 0x27,		//C��Ԫ���Ķ���				
				  REGI_H3U_DW   = 0x28,		//D��Ԫ���Ķ���				
				  REGI_H3U_CW2  = 0x29,	    //C˫��Ԫ���Ķ���
				  REGI_H3U_SM   = 0x2a,		//SM
				  REGI_H3U_SD   = 0x2b,		//SD
				  REGI_H3U_R    = 0x2c		//SD
			  nStartAddr:��Ԫ����ʼ��ַ
			  nCount����Ԫ������
			  pValue�����ݻ�����
 4.ע������ : 1.x��yԪ����ַ��Ϊ8����; 2. ��Ԫ��λCԪ��˫�ּĴ���ʱ��ÿ���Ĵ�����ռ4���ֽڵ�����
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT int H3u_Write_Soft_Elem(SoftElemType eType,int nStartAddr,int nCount,BYTE* pValue,int nNetId = 0);


/******************************************************************************
 1.�������� : ��H3u��Ԫ��
 2.�� �� ֵ :1 �ɹ�  0 ʧ��
 3.��    �� : nNetId:�������ӱ��
			  eType����Ԫ������  
				  REGI_H3U_Y    = 0x20,     //YԪ���Ķ���	
				  REGI_H3U_X    = 0x21,		//XԪ���Ķ���							
				  REGI_H3U_S    = 0x22,		//SԪ���Ķ���				
				  REGI_H3U_M    = 0x23,		//MԪ���Ķ���							
				  REGI_H3U_TB   = 0x24,		//TλԪ���Ķ���				
				  REGI_H3U_TW   = 0x25,		//T��Ԫ���Ķ���				
				  REGI_H3U_CB   = 0x26,		//CλԪ���Ķ���				
				  REGI_H3U_CW   = 0x27,		//C��Ԫ���Ķ���				
				  REGI_H3U_DW   = 0x28,		//D��Ԫ���Ķ���				
				  REGI_H3U_CW2  = 0x29,	    //C˫��Ԫ���Ķ���
				  REGI_H3U_SM   = 0x2a,		//SM
				  REGI_H3U_SD   = 0x2b,		//SD
				  REGI_H3U_R    = 0x2c		//SD
			  nStartAddr:��Ԫ����ʼ��ַ
			  nCount����Ԫ������
			  pValue���������ݻ�����
 4.ע������ : 1.x��yԪ����ַ��Ϊ8����; 2. ��Ԫ��λCԪ��˫�ּĴ���ʱ��ÿ���Ĵ�����ռ4���ֽڵ�����
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT int H3u_Read_Soft_Elem(SoftElemType eType,int nStartAddr,int nCount,BYTE* pValue,int nNetId = 0);


/******************************************************************************
 1.�������� : дAm600��Ԫ��
 2.�� �� ֵ :1 �ɹ�  0 ʧ��
 3.��    �� : nNetId:�������ӱ��
			  eType����Ԫ������    ELEM_QX = 0//QXԪ��  ELEM_MW = 1 //MWԪ��
			  nStartAddr:��Ԫ����ʼ��ַ��QXԪ�����ڴ�С���㣬��ַ��Ҫ����10ȥ��С���㣬��QX10.1��������101��MWԪ��ֱ�Ӿ�������Ԫ����ַ���ô���
			  nCount����Ԫ������
			  pValue�����ݻ�����
 4.ע������ : 
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT int Am600_Write_Soft_Elem(SoftElemType eType,int nStartAddr,int nCount,BYTE* pValue,int nNetId = 0);


/******************************************************************************
 1.�������� : ��Am600��Ԫ��
 2.�� �� ֵ :1 �ɹ�  0 ʧ��
 3.��    �� : nNetId:�������ӱ��
			  eType����Ԫ������   ELEM_QX = 0//QXԪ��  ELEM_MW = 1 //MWԪ��
			  nStartAddr:��Ԫ����ʼ��ַ��QXԪ�����ڴ�С���㣬��ַ��Ҫ����10ȥ��С���㣬��QX10.1��������101������Ԫ�����ô���
			  nCount����Ԫ������
			  pValue���������ݻ�����
 4.ע������ : 
******************************************************************************/
STANDARD_MODBUS_FUNC_EXPORT int Am600_Read_Soft_Elem(SoftElemType eType,int nStartAddr,int nCount,BYTE* pValue,int nNetId = 0);































#endif	//	#if !defined(_INCLUDE_H_)