
// ModbusApiTest.h : PROJECT_NAME Ӧ�ó������ͷ�ļ�
//

#pragma once

#ifndef __AFXWIN_H__
	#error "�ڰ������ļ�֮ǰ������stdafx.h�������� PCH �ļ�"
#endif

#include "resource.h"		// ������


// CModbusApiTestApp:
// �йش����ʵ�֣������ ModbusApiTest.cpp
//

class CModbusApiTestApp : public CWinAppEx
{
public:
	CModbusApiTestApp();

// ��д
	public:
	virtual BOOL InitInstance();

// ʵ��

	DECLARE_MESSAGE_MAP()
};

extern CModbusApiTestApp theApp;