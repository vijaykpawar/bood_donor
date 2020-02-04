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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Donor</title>
<script type="text/javascript">

</script>
</head>
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
			
				<h1>Search Donor</h1>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements disabled -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">Search Donor</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="width: 100%">
								<div id="errorMessageDiv">
									<s:if test="hasActionErrors()">
										<s:actionerror />
									</s:if>
									<s:if test="hasActionMessages()">
										<s:actionmessage />
									</s:if>

								</div>

								<s:form action="searchDonor" 
									theme="bootstrap" cssClass="form-horizontal">
									<s:hidden id="donorId" name="donor.donorId"></s:hidden>
									<div class="form-group">
										<div class="col-md-3">
											<s:textfield placeholder="first name" 
												name="donor.firstName" 
												id="firstName" label="First Name"
												maxlength="50" theme="bootstrap" />
										</div>
										<div class="col-md-3">
											<s:textfield placeholder="last name"
												name="donor.lastName"
												id="lastName" label="Last Name"
												maxlength="50" theme="bootstrap" />
										</div>
										<div class="col-md-3">
											<s:select key="Blood Group"   name="donor.bloodGroup" id="bloodGroup" 
						headerKey="" headerValue="Select"
						list="#{'A+':'A+','A-':'A-','A1+':'A1+','A1-':'A1-','A1B+':'A1B+','A1B-':'A1B-','A2+':'A2+','A2-':'A2-','A2B+':'A2B+','A2B-':'A2B-','AB+':'AB+','AB-':'AB-','B+':'B+','B-':'B-','INRA':'INRA','O+':'O+','O-':'O-'}" title="Select Blood Group" />
									
										</div>
										<div class="col-md-2">
										<s:submit cssClass="btn btn-primary bg-red" value="Search" />
										</div>
									</div>
								</s:form>
								<s:if test="donorList.size() >0">
							<div class="box-body table-responsive">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
										
											<th>First Name </th>
											<th>Last Name</th>
											<th>Blood group</th>
											<th>Address</th>
											<th>Mobile</th>
											<th>Email</th>
											
										</tr>
									</thead>
									<tbody>
										<s:iterator value="donorList" var="donor" status="incr">
											<tr>
										
												<td><s:property value="#donor.firstName" /></td>
												<td><s:property value="#donor.lastName" /></td>
												<td><s:property value="#donor.bloodGroup" /></td>
										       	<td><s:property value="#donor.address" /></td>
												<td><s:property value="#donor.mobile" /></td>
												<td><s:property value="#donor.email" /></td>
												<%--
												<td align="center">
												<span class="glyphicon glyphicon-log-in">
												<s:a href="#"
														onclick="issueStudent('%{#donor.donorId}','%{#donor.firstName}','%{#donor.lastName}')"
														 >SELECT</s:a>
												</span>
												 
														</td> --%>
											</tr>
										</s:iterator>									
									</tbody>
								</table>
							</div>
							</s:if>
							
							</div>
						</div>
					</div>
				</div>
			</section>
		</aside>
	</div>
	<!-- ./wrapper -->
	<s:include value="../include/footer.jsp"></s:include>
	<s:include value="../include/jsIncludes.jsp"></s:include>
</body>
</html>