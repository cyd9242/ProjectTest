<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<link href="<c:url value="/resources/assets/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/tableStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/buttonStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/labelStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/imageStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/msgStyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/divStyle.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<noscript><link href="<c:url value="/resources/assets/css/noscript.css" />" rel="stylesheet"></noscript>
<head>
	<link rel="icon" type="image/x-icon" sizes="16x16" href="/resources/image/titleImage.ico">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<title>전화번호로 아이디 찾기</title>
</head>
<body class="is-preload" name = "top">

	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
		<header id="header" class="alt">	
			<a href = "/virtualHomePage" class = "imageLink"><img src = "/resources/image/home.png" class = "virtualHomePageImageSytle"/></a>
			<nav>
				<a href = "/virtualHomePage/idFind"><button class = "idAndPwdFindbutton">아이디 찾기</button></a>				
			</nav>			
			<nav>
				<a href = "/virtualHomePage/PasswordFind"><button class = "idAndPwdFindbutton">비밀번호 찾기</button></a>
			</nav>
			<nav>
				<a href="#menu" style = "color:white;">Menu</a>
			</nav>
		</header>
		
		<!-- Menu -->
		<nav id="menu">
			<ul class="links">
				<li><a href="index">웹</a></li>
				<li><a href="/virtualHomePage">홈페이지</a></li>
			</ul>
			<ul class="actions stacked">
				<c:if test="${empty pageContext.request.userPrincipal}">
					<li><a href="/virtualHomePage/signUp"><button class="primaryFitbutton">회원가입</button></a></li>
					<li><a href="/virtualHomePage/loginPage"><button class="fitbutton">로그인</button></a></li>
				</c:if>
				<c:if test="${not empty pageContext.request.userPrincipal}">
					<li><a href = "/virtualHomePage/MemberInformation"><button class="fitbutton">${pageContext.request.userPrincipal.name}님</button></a></li>
					<li><a href="${pageContext.request.contextPath}/j_spring_security_logout"><button class="primaryFitbutton">로그아웃</button></a></li>
				</c:if>
			</ul>
		</nav>
		
		<!-- Banner -->
		<section id="banner" class="style7">
			<div class="inner">
				<header class="major">
					<div align = "center">
						<h1 style = "color:white;">가입한 핸드폰 번호로 아이디 찾기</h1>
					</div>
				</header>
			</div>
		</section>
		
		<!-- Main -->
		<div id="main">
			<!-- One -->
			<section id="one">
				<div class="inner">
					<header>
						<div align = "center" class = "telIdFindFormDivStyle">
							<br/>
							<table cellpadding = "0" cellspacing = "0" border = "1" class = "TelIdFindTableStyle" align = "center">
								<form:form action = "/virtualHomePage/idFind/TelIdFindResult" commandName="VVO" method = "post"  onsubmit="return checkResult()">
									<tbody>
										<tr>
											<th>이름</th>
											<td colspan = "3" style = "padding: 7px;" >
												<form:input path = "vName" id = "vName" placeholder = " 이름" style = "position:relative; left:15px; border:none; background:transparent; width:85%; vertical-align: center;"/>
											</td>
										</tr>
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										
										<tr align = "center">
											<th>생년월일</th>
											<td style = "padding:7px;">
												<form:select align = "center" path="vBirth1" style = "width:60%;" id = "vBirth1">
													<form:option value="년도" selected="selected">년도</form:option>
													<form:option value="2006">2006</form:option>
													<form:option value="2005">2005</form:option>
													<form:option value="2004">2004</form:option>
													<form:option value="2003">2003</form:option>
													<form:option value="2002">2002</form:option>
													<form:option value="2001">2001</form:option>
													<form:option value="2000">2000</form:option>
													<form:option value="1999">1999</form:option>
													<form:option value="1998">1998</form:option>
													<form:option value="1997">1997</form:option>
													<form:option value="1996">1996</form:option>
													<form:option value="1995">1995</form:option>
													<form:option value="1994">1994</form:option>
													<form:option value="1993">1993</form:option>
													<form:option value="1992">1992</form:option>
													<form:option value="1991">1991</form:option>
													<form:option value="1990">1990</form:option>
													<form:option value="1989">1989</form:option>
													<form:option value="1988">1988</form:option>
													<form:option value="1987">1987</form:option>
													<form:option value="1986">1986</form:option>
													<form:option value="1985">1985</form:option>
													<form:option value="1984">1984</form:option>
													<form:option value="1983">1983</form:option>
													<form:option value="1982">1982</form:option>
													<form:option value="1981">1981</form:option>
													<form:option value="1980">1980</form:option>
													<form:option value="1979">1979</form:option>
													<form:option value="1978">1978</form:option>
													<form:option value="1977">1977</form:option>
													<form:option value="1976">1976</form:option>
													<form:option value="1975">1975</form:option>
													<form:option value="1974">1974</form:option>
													<form:option value="1973">1973</form:option>
													<form:option value="1972">1972</form:option>
													<form:option value="1971">1971</form:option>
													<form:option value="1970">1970</form:option>
													<form:option value="1969">1969</form:option>
													<form:option value="1968">1968</form:option>
													<form:option value="1967">1967</form:option>
													<form:option value="1966">1966</form:option>
													<form:option value="1965">1965</form:option>
													<form:option value="1964">1964</form:option>
													<form:option value="1963">1963</form:option>
													<form:option value="1962">1962</form:option>
													<form:option value="1961">1961</form:option>
													<form:option value="1960">1960</form:option>
													<form:option value="1959">1959</form:option>
													<form:option value="1958">1958</form:option>
													<form:option value="1957">1957</form:option>
													<form:option value="1956">1956</form:option>
													<form:option value="1955">1955</form:option>
													<form:option value="1954">1954</form:option>
													<form:option value="1953">1953</form:option>
													<form:option value="1952">1952</form:option>
													<form:option value="1951">1951</form:option>
													<form:option value="1950">1950</form:option>
													<form:option value="1949">1949</form:option>
													<form:option value="1948">1948</form:option>
													<form:option value="1947">1947</form:option>
													<form:option value="1946">1946</form:option>
													<form:option value="1945">1945</form:option>
													<form:option value="1944">1944</form:option>
													<form:option value="1943">1943</form:option>
													<form:option value="1942">1942</form:option>
													<form:option value="1941">1941</form:option>
													<form:option value="1940">1940</form:option>
													<form:option value="1939">1939</form:option>
													<form:option value="1938">1938</form:option>
													<form:option value="1937">1937</form:option>
													<form:option value="1936">1936</form:option>
													<form:option value="1935">1935</form:option>
													<form:option value="1934">1934</form:option>
													<form:option value="1933">1933</form:option>
													<form:option value="1932">1932</form:option>
													<form:option value="1931">1931</form:option>
													<form:option value="1930">1930</form:option>
													<form:option value="1929">1929</form:option>
													<form:option value="1928">1928</form:option>
													<form:option value="1927">1927</form:option>
													<form:option value="1926">1926</form:option>
													<form:option value="1925">1925</form:option>
													<form:option value="1924">1924</form:option>
													<form:option value="1923">1923</form:option>
													<form:option value="1922">1922</form:option>
													<form:option value="1921">1921</form:option>
													<form:option value="1920">1920</form:option>
												</form:select><label class = "TelIdFindLabel">년</label>&nbsp;&nbsp; 
											</td>
											<td>
												<form:select path = "vBirth2" id = "vBirth2">
													<form:option value="월" selected="selected">월</form:option>
													<form:option value="01">01</form:option>
													<form:option value="02">02</form:option>
													<form:option value="03">03</form:option>
													<form:option value="04">04</form:option>
													<form:option value="05">05</form:option>
													<form:option value="06">06</form:option>
													<form:option value="07">07</form:option>
													<form:option value="08">08</form:option>
													<form:option value="09">09</form:option>
													<form:option value="10">10</form:option>
													<form:option value="11">11</form:option>
													<form:option value="12">12</form:option>
												</form:select><label class = "TelIdFindLabel">월</label>&nbsp;&nbsp;
											</td>
											<td>
												<form:select path = "vBirth3" id = "vBirth3">
													<form:option value="일" selected="selected">일</form:option>
													<form:option value="01">01</form:option>
													<form:option value="02">02</form:option>
													<form:option value="03">03</form:option>
													<form:option value="04">04</form:option>
													<form:option value="05">05</form:option>
													<form:option value="06">06</form:option>
													<form:option value="07">07</form:option>
													<form:option value="08">08</form:option>
													<form:option value="09">09</form:option>
													<form:option value="10">10</form:option>
													<form:option value="11">11</form:option>
													<form:option value="12">12</form:option>
													<form:option value="13">13</form:option>
													<form:option value="14">14</form:option>
													<form:option value="15">15</form:option>
													<form:option value="16">16</form:option>
													<form:option value="17">17</form:option>
													<form:option value="18">18</form:option>
													<form:option value="19">19</form:option>
													<form:option value="20">20</form:option>
													<form:option value="21">21</form:option>
													<form:option value="22">22</form:option>
													<form:option value="23">23</form:option>
													<form:option value="24">24</form:option>
													<form:option value="25">25</form:option>
													<form:option value="26">26</form:option>
													<form:option value="27">27</form:option>
													<form:option value="28">28</form:option>
													<form:option value="29">29</form:option>
													<form:option value="30">30</form:option>
													<form:option value="31">31</form:option>
												</form:select><label class = "TelIdFindLabel">일</label>&nbsp;&nbsp;
											</td>
										</tr>
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										<tr align = "center">
											<th>전화번호</th>
											<td style = "padding:7px;" align = "center" colspan = "3">
												<form:select align = "center" path="vTel1" id = "vTel1">
													<form:option value="번호" selected="selected">번호</form:option>
													<form:option value="010">010</form:option>
													<form:option value="011">011</form:option>
													<form:option value="016">016</form:option>
													<form:option value="017">017</form:option>
												</form:select><label class = "TelIdFindLabel">-</label> 
												<form:input path = "vTel2" id = "vTel2" maxlength = "4" style = "border:none; background:none; width:20%; text-align: center;"/><label class = "TelIdFindLabel">-</label>    
												<form:input path = "vTel3" id = "vTel3" maxlength = "4" style = "border:none; background:none; width:20%; text-align: center;"/>
											</td>  
										
										</tr> 
										<tr>
											<th style = "background: none;">
												<br/><br/>
											</th>
										</tr>
										<tr>
											<td colspan = "4" align = "center">
												<input type = "submit" class = "TelIdFindbutton" value = "아이디 찾기">
											</td>
										</tr>
									</tbody>
								</form:form>
							</table>
							<br/><br/><br/><br/>
						</div>
					</header>
				</div>
			</section>
		</div>
	</div>

	<button id = "top" class = "Topbutton" hidden = ""><img src = "/resources/image/top.png" class = "topImageStyle"/></button>
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.scrolly.min.js"></script>
	<script src="/resources/assets/js/jquery.scrollex.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src='<c:url value="/resources/js/telFocus.js"/>'></script>
	<script src='<c:url value="/resources/js/TelIdFindCheck.js"/>'></script>
	<script src='<c:url value="/resources/js/hiddenTop.js"/>'></script>
</body>
</html>