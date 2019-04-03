

'===============================================================================================
'	Name of the Function	:	quote
'	Scope of the Function   :  	Public
'	Author 		   	: 	
'	Description 		:     using double quoute in string   							
'	Parameters accepted	:	
'	Parameter returned 	:	
'	Date and / or Version 	: 	version 1.0
'=============================================================================================== 

Function Quote(ByVal s)
	Quote = Null
	If (VarType(s) = vbString) Then
		Quote = Chr(34) & CStr(s) & Chr(34)
End If
End Function



'===============================================================================================
'	Name of the Function	:	killprocess
'	Scope of the Function   :  	Public
'	Author 		   	: 	
'	Description 		: 	Kill the Excel process   							
'	Parameters accepted	:	
'	Parameter returned 	:	
'	Date and / or Version 	: 	version 1.0
'=============================================================================================== 

Function killprocess(strkillProcess)
   strComputername="."
   Set objImpersonate=GetObject("winmgmts:"& "{impersonationlevel=impersonate}!\\"&strComputername& "\root\cimv2")
   Set processname=objImpersonate.execquery("Select * from win32_process where name like '" & strkillProcess & "%'")
   For each processname in processname
		processname.terminate()
   Next
   Set objImpersonate=Nothing
    Set processname=Nothing
End Function