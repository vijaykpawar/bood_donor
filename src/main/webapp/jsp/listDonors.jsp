<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Donor List</title>
<s:include value="../include/cssIncludes.jsp"></s:include>
<sx:head/>
</head>
<body class="skin-blue">
	<s:include value="../include/header.jsp"></s:include>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
	
		<s:include value="../include/sidebar.jsp"></s:include>
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>List Donors</h1>
			</section>
			<section class="content">
				<div class="row">
					<s:form name="deluserFrm" id="deluserFrm" action="">

					</s:form>
					<div class="col-xs-12">
						<div class="box">
							<!-- /.box-header -->
							<div id="errorMessageDiv">
								<s:if test="hasActionErrors()">
										<s:actionerror />
								</s:if>
								<s:if test="hasActionMessages()">
										<s:actionmessage />
								</s:if>
		
							</div>
		
							<div class="box-body table-responsive">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
										<th>Action</th>
											<th>Donor Id</th>
											<th>First Name </th>
											<th>Last Name</th>
											<th>Blood Group</th>
											<th>Address</th>
											<th>Mobile</th>
											<th>Email</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="donorList" var="d" status="incr">
											<tr>
											    <td>
											    <s:a href="prepareEditDonor?donorId=%{#d.donorId}" 
									cssClass="btn">
									<i class="fa fa-edit"></i>
								</s:a>
											    </td>
											
												<td><s:property value="#d.donorId" /></td>
												<td><s:property value="#d.firstName" /></td>
												<td><s:property value="#d.lastName" /></td>
												<td><s:property value="#d.bloodGroup" /></td>
										       	<td><s:property value="#d.address" /></td>
												<td><s:property value="#d.mobile" /></td>
												<td><s:property value="#d.email" /></td>
											</tr>
										</s:iterator>									
									</tbody>
								</table>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
				</div>
			</section>
		</aside>
	</div>
	<!-- ./wrapper -->

	<s:include value="../include/footer.jsp"></s:include>
	<s:include value="../include/jsIncludes.jsp"></s:include>
	<script type="text/javascript">
	$(function() {
		$('#example1').dataTable({bFilter: false, bInfo: false});
	});
</script>
</body>

</html>