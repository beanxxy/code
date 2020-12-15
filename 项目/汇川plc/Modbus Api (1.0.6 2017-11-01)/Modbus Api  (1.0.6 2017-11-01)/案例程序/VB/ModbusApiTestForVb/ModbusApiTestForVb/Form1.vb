Imports System.Runtime.InteropServices

Public Class Form1

    '软元件类型
    Public Enum emsoftElemType
        'AM600
        ELEM_QX = 0 'QX元件
        ELEM_MW = 1 'MW元件
        ELEM_X = 2 'X元件(对应QX200~QX300)
        ELEM_Y = 3 'Y元件(对应QX300~QX400)

        'H3U
        REGI_H3U_Y = &H20     'Y元件的定义	
        REGI_H3U_X = &H21     'X元件的定义							
        REGI_H3U_S = &H22     'S元件的定义				
        REGI_H3U_M = &H23     '/M元件的定义							
        REGI_H3U_TB = &H24     'T位元件的定义				
        REGI_H3U_TW = &H25     'T字元件的定义				
        REGI_H3U_CB = &H26     'C位元件的定义				
        REGI_H3U_CW = &H27     'C字元件的定义				
        REGI_H3U_DW = &H28     'D字元件的定义				
        REGI_H3U_CW2 = &H29     'C双字元件的定义
        REGI_H3U_SM = &H2A     'SM
        REGI_H3U_SD = &H2B     '
        REGI_H3U_R = &H2C        '
    End Enum

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function Init_ETH_String(ByVal ipAddress As String, ByVal nSocketId As Int32, ByVal nPortNo As Int32) As Boolean
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function Exit_ETH(ByVal nSocketId As Int32) As Boolean
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function H3u_Write_Soft_Elem_Int16(ByVal seType As emsoftElemType, ByVal nStartAddr As Int32, ByVal nCount As Int32, ByVal Buffer() As Int16, ByVal nNetId As Int32) As Int32
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function H3u_Write_Soft_Elem_Int32(ByVal seType As emsoftElemType, ByVal nStartAddr As Int32, ByVal nCount As Int32, ByVal Buffer() As Int32, ByVal nNetId As Int32) As Int32
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function H3u_Read_Soft_Elem_Int32(ByVal seType As emsoftElemType, ByVal nStartAddr As Int32, ByVal nCount As Int32, ByVal Buffer() As Int32, ByVal nNetId As Int32) As Int32
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function H3u_Write_Soft_Elem_Float(ByVal seType As emsoftElemType, ByVal nStartAddr As Int32, ByVal nCount As Int32, ByVal Buffer() As Single, ByVal nNetId As Int32) As Int32
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function H3u_Read_Soft_Elem(ByVal seType As emsoftElemType, ByVal nStartAddr As Int32, ByVal nCount As Int32, ByVal Buffer() As Byte, ByVal nNetId As Int32) As Int32
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function Am600_Write_Soft_Elem(ByVal seType As emsoftElemType, ByVal nStartAddr As Int32, ByVal nCount As Int32, ByVal Buffer() As Byte, ByVal nNetId As Int32) As Int32
    End Function

    <DllImport("StandardModbusApi.dll", CharSet:=CharSet.Ansi, CallingConvention:=CallingConvention.Cdecl)>
    Public Shared Function Am600_Read_Soft_Elem(ByVal seType As emsoftElemType, ByVal nStartAddr As Int32, ByVal nCount As Int32, ByVal Buffer() As Byte, ByVal nNetId As Int32) As Int32
    End Function

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim bRes As Boolean
        Dim nLinkId As Int32 : nLinkId = 0
        Dim nPort As Int32 : nPort = 502

        bRes = Init_ETH_String("10.44.52.239", nLinkId, nPort)

        If bRes = True Then
            MsgBox("连接成功！")
        Else
            MsgBox("连接失败！")
        End If

    End Sub


    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs)
        Dim bRes As Boolean
        Dim nLinkId As Int32 : nLinkId = 0
        bRes = Exit_ETH(nLinkId)

        If bRes = True Then
            MsgBox("关闭成功！")
        Else
            MsgBox("关闭失败！")
        End If

    End Sub


    Private Sub Button2_Click_1(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Dim bRes As Boolean
        Dim nLinkId As Int32 : nLinkId = 0
        bRes = Exit_ETH(nLinkId)

        If bRes = True Then
            MsgBox("关闭成功！")
        Else
            MsgBox("关闭失败！")
        End If

    End Sub

    Private Sub Button3_Click_1(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        Dim nRes As Int32
        Dim nValue As Int32 : nValue = 65537 '要写的数据
        Dim nLinkId As Int32 : nLinkId = 0 '连接号
        Dim nAddr As Int32 : nAddr = 100 '寄存器地址
        Dim nCount As Int32 : nCount = 2 '寄存器个数
        Dim Buffer(2) As Int32 '数据缓冲区

        '把值存入缓冲区
        Buffer(0) = nValue

        nRes = H3u_Write_Soft_Elem_Int32(emsoftElemType.REGI_H3U_DW, nAddr, nCount, Buffer, nLinkId)

        If nRes = 1 Then
            MsgBox("写寄存器成功！")
        Else
            MsgBox("写寄存器失败！")
        End If
    End Sub

    Private Sub Button4_Click_1(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Dim nRes As Int32
        Dim nValue As Int16 : nValue = 0 '存储读的数据
        Dim nLinkId As Int32 : nLinkId = 0 '连接号
        Dim nAddr As Int32 : nAddr = 100 '寄存器地址
        Dim nCount As Int32 : nCount = 2 '寄存器个数
        Dim Buffer(2) As Int32 '数据缓冲区

        '把值存入缓冲区

        nRes = H3u_Read_Soft_Elem_Int32(emsoftElemType.REGI_H3U_DW, nAddr, nCount, Buffer, nLinkId)



        If nRes = 1 Then
            MsgBox("读寄存器成功！")
        Else
            MsgBox("读寄存器失败！")
        End If
    End Sub
End Class
