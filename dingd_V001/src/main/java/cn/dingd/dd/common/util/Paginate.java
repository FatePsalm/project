package cn.dingd.dd.common.util;

public class Paginate {

	public static String MyPaginate(String actionUrl, String urlParas,
			int currentPage, int totalPage, String path) {
		String html_paginate = "";
		int startPage = 0;
		int endPage = 0;
		if (urlParas == null) {
			urlParas = "";
		}

		if ((totalPage > 0) && (currentPage <= totalPage)) {
			startPage = currentPage - 4;
			if (startPage < 1) {
				startPage = 1;
			}
			endPage = currentPage + 4;
			if (endPage > totalPage) {
				endPage = totalPage;
			}

			html_paginate += "<div class='task-page-list'><a href='javascript:;'  onclick='fenye(\"1\",\"sou\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' class='btn-page btn-begin'>首页</a>";
			//" + path + actionUrl + "/"+ urlParas + "/1
			if (currentPage <= 8) {
				startPage = 1;
			}

			if ((totalPage - currentPage) < 8) {
				endPage = totalPage;
			}
			if (currentPage == 1) {
				html_paginate += "<span class='btn-page' id=''>上一页</span>";
			} else {
				html_paginate += "<a href='javascript:;' id='' onclick='fenye("+(currentPage - 1)+",\"shang\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' class='btn-page'>上页</a>";
				// " + path + actionUrl + "/"+ urlParas + "/" + (currentPage - 1)+ "
			}
			if (currentPage > 8) {
				html_paginate += "<a class='btn-pages' onclick='fenye(\""+1+"\",\"one\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' href='javascript:;'>1</a>";
				html_paginate += "<a class='btn-pages' onclick='fenye(\""+2+"\",\"two\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' href='javascript:;'>2</a>";
				html_paginate +="<span class='btn-pages'>…</span>";
			}

			for (int i = startPage; i <= endPage; i++) {
				if (currentPage == i) {
					html_paginate += "<span class='btn-pages btn-now'>" + i + "</span>";
				} else {
					html_paginate += "<a class='btn-pages' href='javascript:;' onclick='fenye(\""+i+"\",\"gu\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")'>" + i + "</a>";
					//" + path + actionUrl + "/"+ urlParas + "/" + i + "
				}
			}

			if ((totalPage - currentPage) >= 8) {
				html_paginate += "<span class='btn-pages'>…</span>";
				html_paginate += "<a class='btn-pages' onclick='fenye(\""+(totalPage - 1)+"\",\"lasttwo\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' href='javascript:;'>" + (totalPage - 1)
						+ "</a>";
				html_paginate += "<a class='btn-pages' onclick='fenye(\""+(totalPage)+"\",\"lastone\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' href='javascript:;'>" + (totalPage) + "</a>";
			}

			if (currentPage == totalPage) {
				html_paginate += "<span class='btn-page' id=''>下一页</span>";
			} else {
				html_paginate += "<a href='javascript:void(0);' id='' onclick='fenye(\""+(currentPage + 1)+"\",\"xia\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' class='btn-page' rel=''>下一页</a>";
				//" + path + actionUrl + "/"+ urlParas + "/" + (currentPage + 1)+ "
			}
			html_paginate += "<a  href='javascript:void(0);' onclick='fenye(\""+totalPage+"\",\"wei\",\""+path+"\",\""+actionUrl+"\",\""+urlParas+"\")' class='btn-page btn-end'>尾页</a></div>";
			// " + path + actionUrl + "/" + urlParas+ "/" + totalPage + "
		}else{
			html_paginate +="<div class='task-page task-page-cneter'><ul class='task-page-list'><li class='btn-page btn-begin' onclick='fanye(1)'>首页</li><li class='btn-page'>上一页</li><li class='btn-pages  btn-now' onclick='fanye(1)'>1</li><li class='btn-page'>下一页</li><li class='btn-page btn-end' onclick='fanye(0)'>末页</li></ul></div>";
		}
		return html_paginate;
	}

}
