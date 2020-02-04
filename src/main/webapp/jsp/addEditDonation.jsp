<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.label{
color: black;
}
</style>
<%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
   %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blood Donation Entry</title>
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
					<s:if test="%{donation.donationId >0}">
					     <h1>Edit Blood Donation Info</h1>
					</s:if>
					<s:else>
						<h1>Add Blood Donation Info</h1>	
					</s:else>
				
			</section>
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<!-- general form elements disabled -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">Donation Info</h3>
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
								<s:form action="addEditDonation" 
									theme="bootstrap" cssClass="form-horizontal">
									<div class="form-group">
										<s:hidden name="donation.donationId"></s:hidden>
										<div class="col-md-6">
										    <label>Date Of Donation</label>
										    
											<sx:datetimepicker  name="donation.dateOfDonation" label="Date of Donation" 
											displayFormat="dd-MMM-yyyy" value="%{'2018-07-07'}" />
									     
									     
										</div>
										<div class="col-md-6">
										    <s:textarea placeholder="Comments " maxlength="300" theme="bootstrap" label="Comments" name="donation.comments" cols="40" rows="3"/>
										</div>
										
									</div>
									<div class="form-group">
											<div class="col-md-6">
												<s:textfield placeholder="e-mail "  requiredLabel="true"
														name="donation.email" 
														id="email" label="Donor Email"
														maxlength="50" theme="bootstrap" />
											</div>
											<div class="col-md-6">
												<s:textfield placeholder="Blood Quantity"  requiredLabel="true"
														name="donation.bloodQty" 
														id="quantity" label="Blood Quantity"
														maxlength="50" theme="bootstrap" />
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
	<s:include value="../include/footer.jsp"></s:include>
	<s:include value="../include/jsIncludes.jsp"></s:include>
</body>
</html>