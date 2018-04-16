function disableSubmit(finalResult,submitButtonId) {
	if(finalResult) {
		document.getElementById(submitButtonId).disabled = true;
		return finalResult;
	}else {
		return finalResult;
	}
}

function batchDelete(action,checkboxName,form){
    if (!hasOneChecked(checkboxName)){
            alert('请选择要操作的对象!');
            return;
    }
    if (confirm('确定执行[删除]操作?')){
        form.action = action;
        form.submit();
    }
}

function hasOneChecked(name){
    var items = document.getElementsByName(name);
    if (items.length > 0) {
        for (var i = 0; i < items.length; i++){
            if (items[i].checked == true){
                return true;
            }
        }
    } else {
        if (items.checked == true) {
            return true;
        }
    }
    return false;
}

function setAllCheckboxState(name,state) {
	var elms = document.getElementsByName(name);
	for(var i = 0; i < elms.length; i++) {
		elms[i].checked = state;
	}
}

function getReferenceForm(elm) {
	while(elm && elm.tagName != 'BODY') {
		if(elm.tagName == 'FORM') return elm;
		elm = elm.parentNode;
	}
	return null;
}
/**
 * checked全选反选事件
 * @param name 需要全选反选checked的name
 * @param choose 全选是0、全不选1、反选2
 */
function checkedChoose(name, choose) {
    var checks = document.getElementsByName(name);
    switch (choose) {
        case 0:
            for (var i = 0; i < checks.length; i++) {
                checks[i].checked = true;
            }
            break;
        case 1:
            for (var i = 0; i < checks.length; i++) {
                checks[i].checked = false;
            }
            break;
        case 2:
            for (var i = 0; i < checks.length; i++) {
                checks[i].checked = !checks[i].checked;
            }
    }
}