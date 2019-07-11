		function myAllBox(obj){
			//选中所有的子的box
			var ids=document.getElementsByName("anycheck");
			for(var i=0;i<ids.length;i++){
				//让所有子的box的选中状态和allBox的选中状态一致即可
				ids[i].checked=obj.checked;
			}
		}
		
		function mySubBox(){
			//如果选中的box小于所有的box说明至少有一个box没选中,那么全选的box取消选中状态
			var ids=document.getElementsByName("anycheck");
			var flag=0;
			for(var i=0;i<ids.length;i++){
				if(ids[i].checked){
					//如果是true说明选中
					flag++;
				}
			}
			if(flag==anycheck.length){
				//如果相等说明所有的子box都选中了
				document.getElementsByName("allcheck").checked=true;
			}else{
				document.getElementsByName("allcheck").checked=false;
			}
		}