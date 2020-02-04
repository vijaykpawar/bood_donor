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
<title>Registration</title>
<s:include value="include/cssIncludes.jsp"></s:include>
<sx:head/>
</head>
<body class="skin-blue">
	
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
	
		<aside class="">
			<!-- Content Header (Page header) -->
			
			<section class="content">
				<section class="content-header">
				<h1>Registration</h1>
			</section>
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements disabled -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">Donor Info</h3>
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
								<s:form action="registerDonor" 
									theme="bootstrap" cssClass="form-horizontal">
									<div class="form-group">
										<s:hidden name="donor.donorId"></s:hidden>
										<div class="col-md-6">
											<s:textfield placeholder="First Name "  requiredLabel="true"
												name="donor.firstName" 
												id="name" label="First Name"
												maxlength="50" theme="bootstrap" />
										
										</div>
										<div class="col-md-6">
											<s:textfield placeholder="Last Name "  requiredLabel="true"
												name="donor.lastName" 
												id="name" label="Last Name"
												maxlength="50" theme="bootstrap" />
										</div>
										
									</div>
									<div class="form-group">
									<div class="col-md-6">
									
										<s:select key="Blood Group"   name="donor.bloodGroup" id="bloodGroup" 
						headerKey="" headerValue="Select"
						list="#{'A+':'A+','A-':'A-','A1+':'A1+','A1-':'A1-','A1B+':'A1B+','A1B-':'A1B-','A2+':'A2+','A2-':'A2-','A2B+':'A2B+','A2B-':'A2B-','AB+':'AB+','AB-':'AB-','B+':'B+','B-':'B-','INRA':'INRA','O+':'O+','O-':'O-'}" title="Select Blood Group" />
										<s:textfield placeholder="e-mail "  requiredLabel="true"
												name="donor.email" 
												id="email" label="email"
												maxlength="50" theme="bootstrap" />
										</div>
										<div class="col-md-6">
												<s:textarea placeholder="Address " maxlength="300" theme="bootstrap" label="Address" name="donor.address" cols="40" rows="3"/>
										</div>
										
									</div>
									<div class="form-group">
									<div class="col-md-6">
											<s:textfield placeholder="weight"  requiredLabel="true"
												name="donor.weight" 
												id="weight" label="Weight"
												maxlength="50" theme="bootstrap" />
											
										</div>
										<div class="col-md-6">
											<s:textfield placeholder="contact No "
												name="donor.mobile" 
												id="contactno" label="Mobile No"
												maxlength="50" theme="bootstrap" />
										</div>
									</div>
									<div class="form-group">
										
										<div class="col-md-6">
											<s:textfield placeholder="Age"  requiredLabel="true"
												name="donor.age" 
												id="age" label="Age"
												maxlength="50" theme="bootstrap" />
										
										</div>
										<div class="col-md-6">
											<s:select key="Gender"   name="donor.gender" id="gender" 
											headerKey="" headerValue="Select"
											list="#{'Male':'Male','Female':'Female'}" title="Select Gender" />
										
										</div>
										
									</div>
									
									<div class="form-group">
										
										<div class="col-md-6">
										    <label>Date Of Birth</label>
										    
											<sx:datetimepicker  name="donor.birthDate" label="BirthDate" 
											displayFormat="dd-MMM-yyyy" value="%{'1990-01-01'}" />
										
										</div>
										<div class="col-md-6">
										    <label>Last Donation Date</label>
											<sx:datetimepicker  name="donor.dateLastDonation" label="Last Donation Date" 
											displayFormat="dd-MMM-yyyy" value="%{'2018-01-01'}" />
										
										</div>
										
									</div>
									
									<div class="box-footer text-center">
										<s:submit cssClass="btn btn-primary bg-red" ></s:submit>
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
	<s:include value="include/footer.jsp"></s:include>
	<s:include value="include/jsIncludes.jsp"></s:include>
</body>
</html>