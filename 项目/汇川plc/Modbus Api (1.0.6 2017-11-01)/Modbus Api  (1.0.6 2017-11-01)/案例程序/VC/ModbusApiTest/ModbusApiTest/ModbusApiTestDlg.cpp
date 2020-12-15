
// ModbusApiTestDlg.cpp : 实现文件
//

#include "stdafx.h"
#include "ModbusApiTest.h"
#include "ModbusApiTestDlg.h"


#include "Hc_Modbus_Api.h"
#pragma comment(lib, "StandardModbusApi.lib")


#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// 用于应用程序“关于”菜单项的 CAboutDlg 对话框

class CAboutDlg : public CDialog
{
public:
	CAboutDlg();

// 对话框数据
	enum { IDD = IDD_ABOUTBOX };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

// 实现
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


// CModbusApiTestDlg 对话框




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


// CModbusApiTestDlg 消息处理程序

BOOL CModbusApiTestDlg::OnInitDialog()
{
	CDialog::OnInitDialog();

	// 将“关于...”菜单项添加到系统菜单中。

	// IDM_ABOUTBOX 必须在系统命令范围内。
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

	// 设置此对话框的图标。当应用程序主窗口不是对话框时，框架将自动
	//  执行此操作
	SetIcon(m_hIcon, TRUE);			// 设置大图标
	SetIcon(m_hIcon, FALSE);		// 设置小图标

	// TODO: 在此添加额外的初始化代码

	return TRUE;  // 除非将焦点设置到控件，否则返回 TRUE
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

// 如果向对话框添加最小化按钮，则需要下面的代码
//  来绘制该图标。对于使用文档/视图模型的 MFC 应用程序，
//  这将由框架自动完成。

void CModbusApiTestDlg::OnPaint()
{
	if (IsIconic())
	{
		CPaintDC dc(this); // 用于绘制的设备上下文

		SendMessage(WM_ICONERASEBKGND, reinterpret_cast<WPARAM>(dc.GetSafeHdc()), 0);

		// 使图标在工作区矩形中居中
		int cxIcon = GetSystemMetrics(SM_CXICON);
		int cyIcon = GetSystemMetrics(SM_CYICON);
		CRect rect;
		GetClientRect(&rect);
		int x = (rect.Width() - cxIcon + 1) / 2;
		int y = (rect.Height() - cyIcon + 1) / 2;

		// 绘制图标
		dc.DrawIcon(x, y, m_hIcon);
	}
	else
	{
		CDialog::OnPaint();
	}
}

//当用户拖动最小化窗口时系统调用此函数取得光标
//显示。
HCURSOR CModbusApiTestDlg::OnQueryDragIcon()
{
	return static_cast<HCURSOR>(m_hIcon);
}


void CModbusApiTestDlg::OnBnClickedButton1()
{
	// TODO: 在此添加控件通知处理程序代码
	int nNetId = 0;
	int nIpPort = 502;
	BOOL  bRet = Init_ETH_String ("10.44.52.239", nNetId, nIpPort);

	if (bRet)
	{
		AfxMessageBox(_T("连接成功"));
	} 
	else
	{
		AfxMessageBox(_T("连接失败"));
	}
}

void CModbusApiTestDlg::OnBnClickedButton3()
{
	// TODO: 在此添加控件通知处理程序代码

	//代码示例1：把65534写入D100中
	{
		SoftElemType eType = REGI_H3U_DW;//寄存器类型
		int nStartAddr = 100;//寄存器地址
		int nCount =1;//寄存器个数
		BYTE pValue[2];//缓冲区
		int nNetId = 0;//连接id
		unsigned short nValue = 65534;

		//把要写的数据存入缓冲区，备写
		memcpy(pValue,&nValue,sizeof(nValue));

		//调用api写数据
		int nRet = H3u_Write_Soft_Elem(eType,nStartAddr,nCount, pValue,nNetId );

		if (nRet)
		{
			AfxMessageBox(_T("写寄存器成功"));
		} 
		else
		{
			AfxMessageBox(_T("写寄存器失败"));
		}
	}

	//代码示例2：把Y5-Y14置位
	{
		SoftElemType eType = REGI_H3U_Y;//寄存器类型
		int nStartAddr = 5;//寄存器起始地址
		int nCount =8;//寄存器个数
		BYTE pValue[8];//缓冲区
		int nNetId = 0;//连接id

		//把要写的数据存入缓冲区，备写
		pValue[0] = 1;//Y5
		pValue[1] = 1;//Y6
		pValue[2] = 1;//Y7
		pValue[3] = 1;//Y10
		pValue[4] = 1;//Y11
		pValue[5] = 1;//Y12
		pValue[6] = 1;//Y13
		pValue[7] = 1;//Y14

		//调用api写数据
		int nRet = H3u_Write_Soft_Elem(eType,nStartAddr,nCount, pValue,nNetId );

		if (nRet)
		{
			AfxMessageBox(_T("写寄存器成功"));
		} 
		else
		{
			AfxMessageBox(_T("写寄存器失败"));
		}
	}

}

void CModbusApiTestDlg::OnBnClickedButton4()
{
	// TODO: 在此添加控件通知处理程序代码

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
			AfxMessageBox(_T("读寄存器成功"));
		} 
		else
		{
			AfxMessageBox(_T("读寄存器失败"));
		}
	}


	//代码示例2：把Y5-Y13置位
	{
		SoftElemType eType = REGI_H3U_Y;//寄存器类型
		int nStartAddr = 5;//寄存器起始地址
		int nCount = 7;//寄存器个数
		BYTE pValue[8];//缓冲区(要是8的整数倍)
		int nNetId = 0;//连接id
		BOOL y5,y6,y7,y10,y11,y12,y13;

		//调用api写数据
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
			AfxMessageBox(_T("写寄存器成功"));
		} 
		else
		{
			AfxMessageBox(_T("写寄存器失败"));
		}
	}

}

void CModbusApiTestDlg::OnBnClickedButton2()
{
	// TODO: 在此添加控件通知处理程序代码
	int nNetId = 0;
	BOOL  bRet = Exit_ETH(nNetId);

	if (bRet)
	{
		AfxMessageBox(_T("连接成功"));
	} 
	else
	{
		AfxMessageBox(_T("连接失败"));
	}

}
