#pragma  once

#ifdef PUBLIC_EXPORT
#define MODBUS_TCP_DLL_FUNC_EXPORT __declspec( dllexport )
#else
#define MODBUS_TCP_DLL_FUNC_EXPORT __declspec( dllimport )
#endif


#define MAX_AXIS_AM600   30
#define MAX_AXIS_H3U     12
struct AddrTypeInfo
{
	DWORD dwAddrStart;		//��ʼ��ַ��Modbus��ַ��
	DWORD dwAddrLen;		//��ַ�ܵĸ���
	DWORD dwAddrType;		//��ַ���ʹ�����ֽ���, 0λ���ͣ�2��WORD�ͣ�4��˫����
};


 struct ModubsMultWriteData
{
	ModubsMultWriteData()
	{
		wAxis = -1;//���
		wStar = -1;//1������0��Ч
		dwPos = -1;////�������Ŀ��λ��
		dwVel = -1;//�������Ŀ���ٶ�
		dwTacc = -1;//����ļӼ���ʱ��
	}
	WORD wAxis;//���
	WORD wStar;//1������0��Ч
	DWORD dwPos;////�������Ŀ��λ��
	DWORD dwVel;//�������Ŀ���ٶ�
	DWORD dwTacc;//����ļӼ���ʱ��
};

 static AddrTypeInfo g_dwReadAddr_H3u_Y[]={
	 {6000, 15, 2},		//���
	 {6020, 15, 2},		//����
	//{6000, 5, 2},		//���
	//{6020, 5, 2},		//���
	 {0, 0,	 0},
 };

 static AddrTypeInfo g_dwReadAddr_H3u[]={
	 {5000, 17, 2},		//���
	 {5100, 17, 2},		//
	 {5200, 17, 2},		//���
	 {5300, 17, 2},		//
	 {5400, 17, 2},		//���
	 {5500, 17, 2},		//
	 {5600, 17, 2},		//���
	 {5700, 17, 2},		//
	 //{5800, 17, 2},		//���
	 //{5900, 17, 2},		//
	 {6100, 17, 2},		//���
	 {6200, 17, 2},		//
	 {6300, 17, 2},		//���
	 {6400, 17, 2},		//
	 //{6500, 17, 2},		//���
	 {0, 0, 0},		//
	 {0, 0, 0},		//���
	 {0, 0, 0},		//
	 {0, 0, 0},		//���
	 {0, 0, 0},		//
	 {0, 0, 0},
 };

 static AddrTypeInfo g_dwReadAddr_Y[]={
	 {8000, 63, 2},		//����
	 {9000, 63, 2},		//���
	 {0, 0,	 0},
 };

 //static AddrTypeInfo g_dwReadAddr[]={
	// {5000, 17, 2},		//���
	// {5100, 17, 2},		//
	// {5200, 17, 2},		//���
	// {5300, 17, 2},		//
	// {5400, 17, 2},		//���
	// {5500, 17, 2},		//
	// {5600, 17, 2},		//���
	// {5700, 17, 2},		//
	// {5800, 17, 2},		//���
	// {5900, 17, 2},		//
	// {6000, 17, 2},		//���
	// {6100, 17, 2},		//
	// {6200, 17, 2},		//���
	// {6300, 17, 2},		//
	// {6400, 17, 2},		//���
	// {6500, 17, 2},		//
	// {6600, 17, 2},		//���
	// {6700, 17, 2},		//
	// {6800, 17, 2},		//���
	// {6900, 17, 2},		//	 
	// {7000, 17, 2},		//���
	// {7100, 17, 2},		//
	// {7200, 17, 2},		//���
	// {7300, 17, 2},		//
	// {7400, 17, 2},		//���
	// {7500, 17, 2},		//
	// {7600, 17, 2},		//���
	// {7700, 17, 2},		//
	// {7800, 17, 2},		//���
	// {7900, 17, 2},		//
	// {0, 0,	 0},
 //};
 static AddrTypeInfo g_dwReadAddr[]={
	 {5000, 24, 2},		//01���
	 {5100, 24, 2},		//02
	 {5200, 24, 2},		//03���
	 {5300, 24, 2},		//04
	 {5400, 24, 2},		//05���
	 {5500, 24, 2},		//06
	 {5600, 24, 2},		//07���
	 {5700, 24, 2},		//08
	 {5800, 24, 2},		//09���
	 {5900, 24, 2},		//10
	 {6000, 24, 2},		//11���
	 {6100, 24, 2},		//12
	 {6200, 24, 2},		//13���
	 {6300, 24, 2},		//14
	 {6400, 24, 2},		//15���
	 {6500, 24, 2},		//16
	 {6600, 24, 2},		//17���
	 {6700, 24, 2},		//18
	 {6800, 24, 2},		//19���
	 {6900, 24, 2},		//20	 
	 {7000, 24, 2},		//21���
	 {7100, 24, 2},		//22
	 {7200, 24, 2},		//23���
	 {7300, 24, 2},		//24
	 {7400, 24, 2},		//25���
	 {7500, 24, 2},		//26
	 {7600, 24, 2},		//27���
	 {7700, 24, 2},		//28
	 {7800, 24, 2},		//29���
	 {7900, 24, 2},		//30
	 {0, 0,	 0},
 };


 static AddrTypeInfo g_dwWiteBitAddr[]={
	 {500*8, 10, 0},		
	 {510*8, 10, 0},		
	 {520*8, 10, 0},		
	 {530*8, 10, 0},		
	 {540*8, 10, 0},		
	 {550*8, 10, 0},		
	 {560*8, 10, 0},		
	 {570*8, 10, 0},		
	 {580*8, 10, 0},		
	 {590*8, 10, 0},		
	 {600*8, 10, 0},		
	 {610*8, 10, 0},		
	 {620*8, 10, 0},		
	 {630*8, 10, 0},		
	 {640*8, 10, 0},		
	 {650*8, 10, 0},		
	 {660*8, 10, 0},		
	 {670*8, 10, 0},		
	 {680*8, 10, 0},		
	 {690*8, 10, 0},	 
	 {700*8, 10, 0},		
	 {710*8, 10, 0},		
	 {720*8, 10, 0},		
	 {730*8, 10, 0},		
	 {740*8, 10, 0},		
	 {750*8, 10, 0},		
	 {760*8, 10, 0},		
	 {770*8, 10, 0},		
	 {780*8, 10, 0},		
	 {790*8, 10, 0},			
	 {0, 0,	 0},
 };

 enum  emPlcDeviceType
 {
	 PLC_DEVICE_AM600 = 0,     //QXԪ��
	 PLC_DEVICE_H3U = 1        //QXԪ��
 };

 
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpConnect(int nport, int IpPort, DWORD IpAddress);
 MODBUS_TCP_DLL_FUNC_EXPORT BOOL  mbtcpConnectString(int nport, int IpPort, char* pIpAddr);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpClose(int nport);

 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpSetTimeout(int nport,int mtime);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpSetDelay(int nport,int mtime);

 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn01(int nport, int node, int address, int Count,int* RxdBuffer,int* RxdLength);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn02(int nport, int node, int address, int Count,int* RxdBuffer,int* RxdLength);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn03(int nport, int node, int address, int Count,int* RxdBuffer,int* RxdLength);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn04(int nport, int node, int address, int Count,int* RxdBuffer,int* RxdLength);

 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn05(int nport, int node, int address, int Count,int value,int* RxdBuffer,int* RxdLength);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn06(int nport, int node, int address, int Count,int value,int* RxdBuffer,int* RxdLength);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn15(int nport, int node, int address, int Count,WORD* TxdBuffer,int* RxdBuffer,int* RxdLength);
 MODBUS_TCP_DLL_FUNC_EXPORT int   mbtcpfcn16(int nport, int node, int address, int Count,WORD* TxdBuffer,int* RxdBuffer,int* RxdLength);
 

 MODBUS_TCP_DLL_FUNC_EXPORT AddrTypeInfo* GetPlcDataFromLocalBuf(int wLinkId);

 MODBUS_TCP_DLL_FUNC_EXPORT AddrTypeInfo* GetPlcDataFromLocalBuf_Y(int wLinkId);

 //MODBUS_TCP_DLL_FUNC_EXPORT void AddStarAxisCmd(int wLinkId, ModubsMultWriteData* pModubsMultWriteData);




 int DataExchange(int nport,const char* pBuffer,int* RxdBuffer,int* RxdLength);




 /******************************************************************************
 1.��������    : ��������
 2.��    ��    : wLinkId--���Ӻţ�ÿ���Ӷ�Ӧһ̨PLC��  wNum--�˶������������
 3.�� �� ֵ    : ��
 4.ע������    : 
******************************************************************************/
 MODBUS_TCP_DLL_FUNC_EXPORT BOOL _SetAxisNum( WORD wNum,int wLinkId);

 
 /******************************************************************************
 1.��������    : ����λԪ��״̬
 2.��    ��    : wLinkId--���Ӻţ�ÿ���Ӷ�Ӧһ̨PLC��  wAddr--�Ĵ�����ַ��modbus��ַ��
                 bState-λԪ��״̬
 3.�� �� ֵ    : TRUE--�ɹ� FALSE--ʧ��  
 4.ע������    : 
******************************************************************************/
 MODBUS_TCP_DLL_FUNC_EXPORT BOOL SetCoilState(int wLinkId,WORD wAddr, BOOL bState);

 
 /******************************************************************************
 1.��������    : �����֣�16λ��Ԫ��״̬
 2.��    ��    : wLinkId--���Ӻţ�ÿ���Ӷ�Ӧһ̨PLC��  wAddr--�Ĵ�����ַ��modbus��ַ��
                 wWordValue--16λ��Ԫ��ֵ
 3.�� �� ֵ    : TRUE--�ɹ� FALSE--ʧ��  
 4.ע������    : 
******************************************************************************/
 MODBUS_TCP_DLL_FUNC_EXPORT BOOL SetWord(int wLinkId,WORD wAddr, WORD wWordValue);

  
 /******************************************************************************
 1.��������    : ����˫�֣�32λ��Ԫ��״̬
 2.��    ��    : wLinkId--���Ӻţ�ÿ���Ӷ�Ӧһ̨PLC��  wAddr--�Ĵ�����ַ��modbus��ַ��
                 wWordValue--16λ��Ԫ��ֵ
 3.�� �� ֵ    : TRUE--�ɹ� FALSE--ʧ��  
 4.ע������    : ��16λ��ǰ����16λ�ں�
******************************************************************************/
 MODBUS_TCP_DLL_FUNC_EXPORT BOOL SetDoubleWord(int wLinkId,WORD wAddr, DWORD dwWordValue);

 /******************************************************************************
 1.��������    : д�˶�ָ��
 2.��    ��    : pValue���洢����ֵ��ָ��
				pAddr:�洢����ֵ�Ĵ�����ַ��ָ��
				wPramConst����������
                wStarteBitAddr���˶�����λԪ����ַ
 3.�� �� ֵ    : TRUE--�ɹ� FALSE--ʧ��  
 4.ע������    : ��16λ��ǰ����16λ�ں�
******************************************************************************/
 MODBUS_TCP_DLL_FUNC_EXPORT BOOL WriteMotionCmd(int* pPramValue,WORD* pAddr, WORD wPramConst, WORD wStarteBitAddr,int nNetId);

 MODBUS_TCP_DLL_FUNC_EXPORT int   StartApiExProcess(int nport, int IpPort, DWORD IpAddress, emPlcDeviceType emType);

/*******************************************************************************
1.��������    : ����д�Ĵ�������ָ��
2.��    ��    : nByteCnt��λԪ������
nWordCnt����Ԫ������
pAddrBuffer:Ԫ����ַ
pRxdBuffer����������
3.�� �� ֵ    : ���ݵĳ��� 
4.ע������    : ��16λ��ǰ����16λ�ں�
*********************************************************************************/

 MODBUS_TCP_DLL_FUNC_EXPORT int  BatchSetReadRegCfg(int nNetId, int nByteCnt, int nWordCnt,WORD* pAddrBuffer,int* pRxdBuffer);

 MODBUS_TCP_DLL_FUNC_EXPORT int  BatchReadReg(int nNetId,int nRcvLen,int* pRxdBuffer);

 extern BOOL  g_bIsStarted;



