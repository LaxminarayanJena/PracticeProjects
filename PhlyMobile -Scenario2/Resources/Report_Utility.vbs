Function Recovery(Obj)
	Obj.CaptureBitmap
	Application("Phly").Close
	set ExeclO = PhlyMobile_Report("","","Smoke","0",ExeclO)
	StopTest
End Function



Function PhlyMobile_Report(Step, StepStatus, SheetName, val, wb)
	If val = "1" then 'Open Excel Report
		Set exobj = CreateObject("Excel.Application")
		Set wb = exobj.Workbooks.Open(getGlobalVar("Report_path"))
		Set PhlyMobile_Report = wb
	Elseif val = "0" then 'Close Excel Report
		wb.Save
		wb.Close
		Set PhlyMobile_Report = nothing
		Set wb=nothing
		Set exobj=nothing
	Elseif (val <> "0") and (val <> "1") then 'Write data to Excel Report on current available line
		Set tempsheet = wb.Worksheets(SheetName)
	    	rows = tempsheet.UsedRange.Rows.Count
		i=rows+1
		tempsheet.cells(i,1) = "Step "&cstr(GetGlobalVar("Iteration"))
		tempsheet.cells(i,2) = Step
		tempsheet.cells(i,3) = StepStatus
		setglobalvar "Iteration",cstr(cint(GetGlobalVar("Iteration"))+1)
		Set PhlyMobile_Report = wb
	End If	
End Function