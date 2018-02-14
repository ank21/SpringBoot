$(document).ready(function() {

	
	$("#datepicker1").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	$("#datepicker2").datepicker({
		dateFormat : 'yy-mm-dd'
	});

	$("#filter").hide();
	$("#fbutton").click(function() {
		$("#filter").toggle()
	});
	
	$(".table").on('click','.edit',function(){
		
		console.log("helo")
	$(this).closest("tr").find("td:eq(2)").empty().append("<select id='se' class='form-control' ng-model='status'><option value='New'>New</option>		<option value='In Progress'>In Progress</option>	<option value='Done'>Done</option></select>");
		
	})
	
	$(".table").on('click','.update',function(){
		
		var t=$('#se').click().val()
		var a=$(this).closest("tr").find("td:eq(2)").html(t);
		$("#hid").val(a);
		
		var b=$("#hid").val();
		alert("hello");
	
	})
	
	
	
	
	
});

