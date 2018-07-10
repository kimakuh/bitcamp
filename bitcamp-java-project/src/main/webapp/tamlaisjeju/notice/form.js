
if (location.href.split("?").length > 1) {
	var tags = $(".input-view");
    tags.css("display", "none");
    
	var no = location.href.split("?")[1].split("=")[1];
	
	$.getJSON( serverRoot +"/json/notice/" + no, function(data) {
        $(fNo).val(data.no);
        $(fTitle).val(data.title);
        $(fContent).val(data.content);
        $(fName).val(data.name);
        $(fCreatedDate).val(data.createdDate);
        $(fCount).val(data.count);
        $(fDown).val(data.down);
	});
	
	$("#updBtn").click(() => {
		$.post( serverRoot + "/json/notice/update", {
			title: $(fTitle).val(),
			content: $(fContent).val(),
			no: $(fNo).val()
			
		}, () => {
			location.href = "list.html";
		});
	});
	
    $("#delBtn").click(() => {
        if (window.confirm("삭제하시겠습니까?") == false) 
        	return;
        
        $.get( serverRoot + "/json/notice/delete", {"no": no}, () => {
        	location.href = "list.html";
        });
	});
	
} else { // 새 글 등록
    var tags = $(".detail-view");
    tags.css("display", "none");
    
    $("#addBtn").click(() => {
    	$.post( serverRoot +"/json/notice/add", {
    		title: $(fTitle).val(),
            content: $(fContent).val()
    	}, () => {
    		location.href = "list.html";
    	});
    });
}
