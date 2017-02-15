/**
 * 调用后台批量删除方法
 */
function deleteBatch() {
	$("#mainForm").attr("action","deleteBatch.action");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}

/**
 * 点击表头的复选框，实现一键反选
 */

function choseAll() {
	$("input[name='ids']").each(function(){
		if($(this).attr("checked"))
		{
			$(this).removeAttr("checked");
		}
		else
		{
			$(this).attr("checked","true");
		}
	})
}

