<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>团队管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <%@ include file="../common/top.jsp"%>
    	
    <div class="bg">
		  <div class="contain" id="tabs" style="margin:0 auto;">
		    <%@ include file="../company/PublicMenu.jsp"%>
		    <div class="text-box">
					<div class="text-content" id="text-content">
						<h1 class="title">管理团队</h1>
						<p class="mt20 cn_line">
						亿人宝以金融创新基因吸引了来自国内五百强知名企业的业界精英，目前团队成员年轻朝气、充满活力，热爱新事物，勇于接受新挑战，团队成员有信心和决心，要用人人共享的理念在金融改革的浪潮中乘风破浪，要为普通大众创造财富增值的机会，为诚信经营者提供高效便捷的金融服务。 
						</p>
						<div style="padding:20px 0;border-bottom:1px dashed #dbdbdb" class="clearfix">
							<div class="img fl" style="width:130px;">
								<img src="${pageContext.request.contextPath}/images/lxw.jpg" alt="">
							</div>
							<div class="fl" style="width:790px;margin-left:20px;">
								<p>
									<span style="font-size:18px;color:#0aaae1;">王二虎</span>
									<span style="color:#0aaae1;"> 联合创始人</span>
								</p>
								<p style="font-size:16px;line-height:32px;color:#595757">
									曾先后在中国农业银行、招商银行、兴业银行担任高管职务，拥有16年的国内大型银行工作经历，对客户信用风险评估、产品定价机制和市场风险管理策略具有深入的研究，风险管理经验十分丰富。  
								</p>
								<p style="font-size:16px;line-height:32px;color:#595757">
									2015年与合伙人共同创建互联网金融服务平台——亿人宝
								</p>
								<p style="font-size:16px;line-height:32px;color:#595757">
									感言：风控的宗旨在于对风险的预知和防范
								</p>
							</div>
						</div>
						<h1 class="title">组织机构</h1><br>
						<p>
							<img src="${pageContext.request.contextPath}/images/org.png" alt="亿人宝-组织机构" title="亿人宝-组织机构">
						</p>
					</div>
				</div>
		  </div>
		</div>
    	
    
    <%@ include file="../common/foot.jsp"%>
  </body>
</html>
