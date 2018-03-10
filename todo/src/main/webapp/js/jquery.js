$(document).ready(function() {

	
	$("#datepicker1").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$("#datepicker2").datepicker({
		dateFormat : 'yy-mm-dd'
	});

/*	$("#filter").hide();
	$("#fbutton").click(function() {
		$("#filter").toggle()
	});*/
	
	$(document).on('click','body .table .tbody .edit',function(){
		
		
	$(this).closest("tr").find("td:eq(2)").empty().append("<select id='se' class='form-control' ng-model='status'><option value='New'>New</option>		<option value='In Progress'>In Progress</option>	<option value='Done'>Done</option></select>");
		
	})
	
	
	
	
	
	
	
});

