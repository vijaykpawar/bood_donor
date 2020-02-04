<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.label {
	color: black;
}
</style>
<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/Edit Blood Test</title>
<s:include value="../include/cssIncludes.jsp"></s:include>
<sx:head />
</head>
<body class="skin-blue">
	<s:include value="../include/header.jsp"></s:include>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<s:include value="../include/sidebar.jsp"></s:include>
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<s:if test="%{bloodTest.bloodTestId >0}">
					<h1>Edit Blood Test</h1>
				</s:if>
				<s:else>
					<h1>Add Blood Test</h1>
				</s:else>

			</section>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements disabled -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">Blood Tests Info</h3>
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
								<s:form action="addEditBloodTest" theme="bootstrap"
									cssClass="form-horizontal">
									<div class="form-group">
									<s:hidden name="bloodTest.donationId"></s:hidden>
										<s:hidden name="bloodTest.bloodTestId"></s:hidden>
										<div class="col-md-4">
											<s:select key="Hepatitis B" name="bloodTest.hepatitisb"
												id="hepatitisb" headerKey="" headerValue="Select"
												list="#{'Negative':'Negative','Positive':'Positive'}"
												title="Select" />
										</div>
										<div class="col-md-4">
											<s:select key="Hepatitis C" name="bloodTest.hepatitisc"
												id="hepatitisc" headerKey="" headerValue="Select"
												list="#{'Negative':'Negative','Positive':'Positive'}"
												title="Select" />
										</div>
										<div class="col-md-4">
											<s:select key="HTLV Type I" name="bloodTest.htlvType1"
												id="htlvType1" headerKey="" headerValue="Select"
												list="#{'Negative':'Negative','Positive':'Positive'}"
												title="Select" />
										</div>
									</div>
									
									<div class="form-group">
										
										<div class="col-md-4">
											<s:select key="HTLV Type II" name="bloodTest.htlvType2"
												id="htlvType2" headerKey="" headerValue="Select"
												list="#{'Negative':'Negative','Positive':'Positive'}"
												title="Select" />
										</div>
										<div class="col-md-4">
											<s:select key="HIV" name="bloodTest.hiv" requiredLabel="true"
												id="hiv" headerKey="" headerValue="Select"
												list="#{'Negative':'Negative','Positive':'Positive'}"
												title="Select" />
										</div>
										<div class="col-md-4">
											<s:select key="West Nile Virus" name="bloodTest.westNileVirus"
												id="westNileVirus" headerKey="" headerValue="Select"
												list="#{'Negative':'Negative','Positive':'Positive'}"
												title="Select" />
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-md-4">
											<s:select key="Syphilis" name="bloodTest.syphilis"
												id="syphilis" headerKey="" headerValue="Select"
												list="#{'Negative':'Negative','Positive':'Positive'}"
												title="Select" />
										</div>
									</div>
									
									

									<div class="box-footer text-center">
										<s:submit cssClass="btn btn-primary bg-red"></s:submit>
									</div>
								</s:form>
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