<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en" class="uk-height-1-1">
<head>
<meta charset="UTF-8">
<title>Title</title>
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<link rel="stylesheet" href="css/uikit.gradient.min.css" />
<link rel="stylesheet" href="css/main.css" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/uikit.min.js"></script>
<script language="javascript">
	//扩展Date的format方法
	Date.prototype.format = function(format) {
		var o = {
			"M+" : this.getMonth() + 1,
			"d+" : this.getDate(),
			"h+" : this.getHours(),
			"m+" : this.getMinutes(),
			"s+" : this.getSeconds(),
			"q+" : Math.floor((this.getMonth() + 3) / 3),
			"S" : this.getMilliseconds()
		}
		if (/(y+)/.test(format)) {
			format = format.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		}
		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(format)) {
				format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
						: ("00" + o[k]).substr(("" + o[k]).length));
			}
		}
		return format;
	}
	/**
	 *转换日期对象为日期字符串
	 * @param date 日期对象
	 * @param isFull 是否为完整的日期数据,
	 *               为true时, 格式如"2000-03-05 01:05:04"
	 *               为false时, 格式如 "2000-03-05"
	 * @return 符合要求的日期字符串
	 */
	function getSmpFormatDate(date, isFull) {
		var pattern = "";
		if (isFull == true || isFull == undefined) {
			pattern = "yyyy-MM-dd hh:mm:ss";
		} else {
			pattern = "yyyy-MM-dd";
		}
		return getFormatDate(date, pattern);
	}
	/**
	 *转换当前日期对象为日期字符串
	 * @param date 日期对象
	 * @param isFull 是否为完整的日期数据,
	 *               为true时, 格式如"2000-03-05 01:05:04"
	 *               为false时, 格式如 "2000-03-05"
	 * @return 符合要求的日期字符串
	 */

	function getSmpFormatNowDate(isFull) {
		return getSmpFormatDate(new Date(), isFull);
	}
	/**
	 *转换long值为日期字符串
	 * @param l long值
	 * @param isFull 是否为完整的日期数据,
	 *               为true时, 格式如"2000-03-05 01:05:04"
	 *               为false时, 格式如 "2000-03-05"
	 * @return 符合要求的日期字符串
	 */

	function getSmpFormatDateByLong(l, isFull) {
		return getSmpFormatDate(new Date(l), isFull);
	}
	/**
	 *转换long值为日期字符串
	 * @param l long值
	 * @param pattern 格式字符串,例如：yyyy-MM-dd hh:mm:ss
	 * @return 符合要求的日期字符串
	 */

	function getFormatDateByLong(l, pattern) {
		return getFormatDate(new Date(l), pattern);
	}
	/**
	 *转换日期对象为日期字符串
	 * @param l long值
	 * @param pattern 格式字符串,例如：yyyy-MM-dd hh:mm:ss
	 * @return 符合要求的日期字符串
	 */
	function getFormatDate(date, pattern) {
		if (date == undefined) {
			date = new Date();
		}
		if (pattern == undefined) {
			pattern = "yyyy-MM-dd hh:mm:ss";
		}
		return date.format(pattern);
	}

	//alert(getSmpFormatDate(new Date(1279849429000), true));
	//alert(getSmpFormatDate(new Date(1279849429000),false));
	//alert(getSmpFormatDateByLong(1279829423000, true));
	//      //alert(getSmpFormatDateByLong(1279829423000,false));
	//alert(getFormatDateByLong(1279829423000, "yyyy-MM"));
	//alert(getFormatDate(new Date(1279829423000), "yy-MM"));
	//alert(getFormatDateByLong(1279849429000, "yyyy-MM hh:mm"));
</script>
<script>
	$(function() {
		var ip = "192.168.11.118";
		var url = "http://" + ip + ":8080/app/idCardSearch/getList";
		url = "${ctx}/app/idCardSearch/getList"
		//            $.ajax({url:"http://"+ip+":8080/CRM/getTextList",success:function(result){
		//                console.log(result);
		//            }});
		$.get(url, "", function(data, status) {
			//                console.log("Data: " + data + "nStatus: " + status);
			//                console.log(data);
			for ( var i in data) {
				var o = data[i];
				var idCard = o["idCardNum"];
				var phone = o["searchPhone"];
				var x = o["locationX"];
				var y = o["locationY"];
				var myDate = getSmpFormatDateByLong(o["createDate"], true);
				var localtion = o["location"];
				var uuid = o["uuid"];
				var macAddress = o["macAddress"];
				var phoneDetile = o["phoneDetile"];
				var $tr = $(
						"<tr><td>" + idCard + "</td><td>" + phone + "</td><td>"
								+ x + "</td><td>" + y + "</td><td>" + localtion
								+ "</td><td>" + myDate + "</td><td>" + uuid
								+ "</td><td>" + macAddress
								+ "</td><td><a>查看详情</a></td><tr/>").data(o);
				$("#tbody").append($tr);
			}
		}, "json");
		$("#tbody").delegate("a", "click", function() {
			console.log($(this).data());
			var modal = UIkit.modal(".uk-modal");
			var $tr = $(this).parent().parent();
			var data = $tr.data();
			var phoneDetile = data["phoneDetile"]
			$("#context").html(phoneDetile);
			modal.show();
		});
	})
</script>
</head>
<body class="uk-height-1-1">
	<table class="uk-table">
		<thead>
			<tr>
				<th>查询的身份证号</th>
				<th>查询者手机号</th>
				<th>经度</th>
				<th>纬度</th>
				<th>位置</th>
				<th>时间</th>
				<th>uuid</th>
				<th>mac地址</th>
				<th>其他信息</th>
			</tr>
		</thead>
		<tbody id="tbody">
		</tbody>
	</table>
	<div class="uk-modal">
		<div class="uk-modal-dialog">
			<div id="context">暂无信息</div>
			<div class="uk-modal-caption">详细信息</div>
		</div>
	</div>
</body>
</html>
