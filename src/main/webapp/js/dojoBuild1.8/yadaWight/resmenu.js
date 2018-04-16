//>>built
define("yadaWight/resmenu",["dojo/_base/declare","dojo/data/ItemFileWriteStore","dojo/ready","dojo/dom","dijit/Tree","dijit/tree/ForestStoreModel","dijit/Menu","dijit/MenuItem","dojo/_base/array","dojo/aspect","dijit/Dialog","dijit/registry"],function(_1,_2,_3,_4,_5,_6,_7,_8,_9,_a,_b,_c){return _1(null,{url:"",nid:"",typeId:"",typeName:"",parentId:"0",self:this,constructor:function(_d){_1.safeMixin(this,_d);this.getTree().startup();this.addTreeMenu();},set:function(_e,_f){this[_e]=_f;},get:function(_10){return this[_10];},getStore:function(){return new _2({url:this.url});},getModel:function(){return new _6({store:this.getStore(),query:{pmenuResId:this.parentId},rootId:"0",rootLabel:"主菜单",mayHaveChildren:function(_11){var _12="";dojo.xhrGet({url:"res/resIsLeaf_ajax.do?t="+new Date().getTime(),sync:true,content:{menuResId:_11.menuResId},load:function(_13){_12=_13;},error:function(_14){alert(_14);}});if(_12=="0"){return false;}return true;},getChildren:function(_15,_16,_17){if(_15.root==true){if(this.root.children){_16(this.root.children);}else{this.store.fetch({query:this.query,queryOptions:{cache:false},onComplete:dojo.hitch(this,function(_18){this.root.children=_18;_16(_18);}),onError:_17});}}else{var sx=_15.menuResId;this.store.fetch({query:{pmenuResId:sx.toString()},queryOptions:{cache:false},onComplete:dojo.hitch(this,function(_19){_15.children=_19;_16(_19);}),onError:_17});}}});},getTree:function(){return _5({model:this.getModel(),openOnClick:true,domNode:_4.byId(this.nid)});},addTreeMenu:function(){var _1a=this.typeId;var _1b=this.typeName;var _1c=new _7({targetNodeIds:[this.nid],style:"width: 40px;"});_1c.addChild(new _8({label:"Simple menu item"}));_a.before(_1c,"_openMyself",function(_1d){var rn=window.document.elementFromPoint(_1d.coords.x,_1d.coords.y);var tn=dijit.getEnclosingWidget(rn);dojo.forEach(_1c.getChildren(),function(_1e){_1c.removeChild(_1e);},this);var _1f=new _b();menu1=dijit.MenuItem({label:"增加"+tn.item.typeName,onClick:function(){_1f.setAttribute("title","增加"+tn.item.typeName);_1f.setAttribute("style","width: 500px;");_1f.setAttribute("href","res/insert.do?typeId="+_1a+"&treeId="+tn.item.menuResId);_1f.show();}});menu2=dijit.MenuItem({label:"修改"+tn.item.typeName,onClick:function(){_1f.setAttribute("title","修改"+tn.item.typeName);_1f.setAttribute("style","width: 500px;");_1f.setAttribute("href","res/edit.do?typeId="+_1a+"&treeId="+tn.item.menuResId);_1f.show();}});menu3=dijit.MenuItem({label:"删除"+tn.item.typeName,onClick:function(){if(confirm("是否删除"+tn.item.menuName+"?")){window.location.href="delete.do?typeId="+_1a+"&treeId="+tn.item.menuResId;}else{return false;}}});menu4=dijit.MenuItem({label:"增加"+_1b,onClick:function(){_1f.setAttribute("title","增加"+_1b);_1f.setAttribute("style","width: 500px;");_1f.setAttribute("href","res/insert.do?typeId="+_1a+"&treeId=0");_1f.show();}});menu5=dijit.MenuItem({label:"子"+tn.item.typeName+"排序",onClick:function(){var _20=new _b({title:tn.item.menuName+"子"+tn.item.typeName+"排序",style:"width: 500px;",href:"res/showOrderRes.do?typeId="+_1a+"&treeId="+tn.item.menuResId});_20.show();}});menu6=dijit.MenuItem({label:"子"+_1b+"排序",onClick:function(){var _21=new _b({title:"主菜单"+"子"+_1b+"排序",style:"width: 500px;",href:"res/showOrderRes.do?typeId="+_1a+"&treeId=0"});_21.show();}});var _22="";dojo.xhrGet({url:"res/resIsLeaf_ajax.do?t="+new Date().getTime(),sync:true,content:{menuResId:tn.item.menuResId},load:function(_23){_22=_23;},error:function(_24){alert(_24);}});if(tn.label!="主菜单"){_1c.addChild(menu1);_1c.addChild(menu2);}else{_1c.addChild(menu4);}if(_22=="0"){_1c.addChild(menu3);}else{if(tn.label!="主菜单"){_1c.addChild(menu5);}else{_1c.addChild(menu6);}}});_1c.startup();}});});