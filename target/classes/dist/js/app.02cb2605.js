(function(){"use strict";var t={2196:function(t,e,r){r.d(e,{Z:function(){return u}});var o=function(){var t=this,e=t._self._c;return e("div",{staticClass:"echart"},[e("el-card",{attrs:{shadow:"hover"}},[e("el-col",[e("el-card",{attrs:{shadow:"never"}},[e("el-form",{attrs:{inline:!0}},[e("el-form-item",{attrs:{label:"qq号"}},[e("el-input",{attrs:{placeholder:"数据1"},model:{value:t.formInline.user,callback:function(e){t.$set(t.formInline,"user",e)},expression:"formInline.user"}})],1),e("el-form-item",{attrs:{label:"data2"}},[e("el-input",{attrs:{placeholder:"数据2"},model:{value:t.formInline.region,callback:function(e){t.$set(t.formInline,"region",e)},expression:"formInline.region"}})],1),e("el-form-item",[e("el-button",{attrs:{type:"primary"},on:{click:t.onSubmit}},[t._v("查询")])],1)],1)],1)],1),e("el-col",{attrs:{span:20}},[e("div",{staticStyle:{width:"100%",height:"600px"},attrs:{id:"echart"}})])],1)],1)},n=[],a={name:"echart",components:{},data(){return{formInline:{user:"",region:""},option:{title:{text:"测试用例",left:"center"},tooltip:{trigger:"item"},legend:{orient:"vertical",left:"left"},series:[{name:"数量",type:"pie",radius:"50%",data:[{value:1048,name:"测试用例1"},{value:735,name:"测试用例2"},{value:580,name:"测试用例3"}],emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]}}},created(){},methods:{onSubmit(){console.log("submit")},drawChart(){const t=this.$echarts.init(document.getElementById("echart"));t.setOption(this.option)}},mounted(){this.drawChart()}},s=a,l=r(1001),i=(0,l.Z)(s,o,n,!1,null,null,null),u=i.exports},3788:function(t,e,r){r.d(e,{Z:function(){return i}});var o=function(){var t=this,e=t._self._c;return e("div",{staticClass:"hand"},[e("el-col",{attrs:{span:24}},[e("div",{attrs:{id:"hand"}},[t._v(" qq机器人管理系统 ")])])],1)},n=[],a=r(1001),s={},l=(0,a.Z)(s,o,n,!1,null,null,null),i=l.exports},3221:function(t,e,r){r.d(e,{Z:function(){return u}});var o=function(){var t=this,e=t._self._c;return e("div",{staticClass:"Tab"},[e("el-col",{attrs:{span:4}},[e("el-menu",{staticClass:"el-menu-vertical-demo daohang",attrs:{"default-active":"2","background-color":"#545c64","text-color":"#fff","active-text-color":"#ffd04b"},on:{open:t.handleOpen,close:t.handleClose}},[e("h5",[e("el-avatar",{attrs:{size:50},on:{click:function(e){t.drawer=!0}}},[t._v(t._s(this.$attrs.id))]),e("h2",{on:{click:function(e){t.drawer=!0}}},[t._v(t._s(this.$attrs.id))])],1),e("el-menu-item",{attrs:{index:"1"},on:{click:function(e){return t.getTo(1)}}},[e("i",{staticClass:"el-icon-location"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("消息转发")])]),e("el-menu-item",{attrs:{index:"2"},on:{click:function(e){return t.getTo(2)}}},[e("i",{staticClass:"el-icon-menu"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("图状展示")])]),e("el-menu-item",{attrs:{index:"3"}},[e("i",{staticClass:"el-icon-document"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("导航三")])]),e("el-menu-item",{attrs:{index:"4"}},[e("i",{staticClass:"el-icon-setting"}),e("span",{attrs:{slot:"title"},slot:"title"},[t._v("导航四")])])],1)],1),e("el-drawer",{attrs:{direction:"ltr",title:"我是标题",visible:t.drawer,"with-header":!1},on:{"update:visible":function(e){t.drawer=e}}},[e("h1",[t._v("欢迎"+t._s(this.$attrs.id)+"管理员登录使用！")]),e("el-form",[e("el-form-item",[e("el-select",{attrs:{placeholder:"  请选择qq机器人"},model:{value:t.form.region,callback:function(e){t.$set(t.form,"region",e)},expression:"form.region"}},[e("el-option",{attrs:{label:"1123123",value:"1123123"}}),e("el-option",{attrs:{label:"123213",value:"123213"}})],1)],1),e("el-form-item",[e("el-button",{attrs:{type:"primary"},on:{click:t.upaccount}},[t._v("提交账号")])],1)],1),e("el-button",{attrs:{type:"danger",round:""},on:{click:t.outlogin}},[t._v(" 登出账号 ")])],1)],1)},n=[],a=(r(7658),{data(){return{drawer:!1,form:{region:""}}},methods:{getTo(t){1==t?this.$router.push({name:"forward",params:{userId:this.$attrs.id}}):2==t&&this.$router.push({name:"echarts",params:{userId:this.$attrs.id}})},handleOpen(t,e){console.log(t,e)},handleClose(t,e){console.log(t,e)},upaccount(){this.$message({type:"success",message:"已获取数据!"})},outlogin(){this.$confirm("此操作退出账号, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((()=>{this.$message({type:"success",message:"已登出!"}),this.$router.push({name:"home",params:{userId:this.$attrs.id}})})).catch((()=>{this.$message({type:"info",message:"已取消操作!"})}))}}}),s=a,l=r(1001),i=(0,l.Z)(s,o,n,!1,null,null,null),u=i.exports},9205:function(t,e,r){var o=r(6369),n=function(){var t=this,e=t._self._c;return e("div",{attrs:{id:"app"}},[e("router-view",[e("nav",[e("router-link",{attrs:{to:"/"}},[t._v("Home")]),t._v(" | "),e("router-link",{attrs:{to:"/about"}},[t._v("About")]),t._v("| "),e("router-link",{attrs:{to:"/forward"}},[t._v("Forward")])],1)])],1)},a=[],s=r(1001),l={},i=(0,s.Z)(l,n,a,!1,null,null,null),u=i.exports,c=r(2631),d=function(){var t=this,e=t._self._c;return e("div",{staticClass:"home"},[e("div",{staticClass:"title"},[t._v("qq机器人管理系统")]),e("div",{staticClass:"mylogin",attrs:{align:"center"}},[e("h4",[t._v("登录")]),e("el-form",{ref:"loginForm",attrs:{model:t.loginForm,rules:t.loginRules,"label-width":"0px"}},[e("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{label:"",prop:"account"}},[e("el-row",[e("el-col",{attrs:{span:2}},[e("span",{staticClass:"el-icon-s-custom"})]),e("el-col",{attrs:{span:22}},[e("el-input",{staticClass:"inps",attrs:{placeholder:"账号"},model:{value:t.loginForm.account,callback:function(e){t.$set(t.loginForm,"account",e)},expression:"loginForm.account"}})],1)],1)],1),e("el-form-item",{attrs:{label:"",prop:"passWord"}},[e("el-row",[e("el-col",{attrs:{span:2}},[e("span",{staticClass:"el-icon-lock"})]),e("el-col",{attrs:{span:22}},[e("el-input",{staticClass:"inps",attrs:{type:"password",placeholder:"密码"},model:{value:t.loginForm.passWord,callback:function(e){t.$set(t.loginForm,"passWord",e)},expression:"loginForm.passWord"}})],1)],1)],1),e("el-form-item",{staticStyle:{"margin-top":"55px"}},[e("el-button",{staticClass:"submitBtn",attrs:{type:"primary",round:""},on:{click:t.submitForm}},[t._v("登录 ")])],1)],1)],1)])},f=[],p=(r(7658),r(3822)),m={name:"HomeView",data:function(){return{loginForm:{account:"",passWord:""},loginRules:{account:[{required:!0,message:"请输入账号",trigger:"blur"}],passWord:[{required:!0,message:"请输入密码",trigger:"blur"}]}}},methods:{...(0,p.OI)(["changeLogin"]),submitForm(){const t=this.loginForm.account,e=this.loginForm.passWord;return t?e?(console.log("用户输入的账号为：",t),console.log("用户输入的密码为：",e),void this.$router.push({name:"about",params:{userId:t}})):this.$message({type:"error",message:"密码不能为空！"}):this.$message({type:"error",message:"账号不能为空！"})}}},h=m,v=(0,s.Z)(h,d,f,!1,null,null,null),b=v.exports,g=function(){var t=this,e=t._self._c;return e("div",{staticClass:"forward"},[e("Hand"),e("Tab",{attrs:{id:t.userid}}),e("Forward_contentVue")],1)},_=[],q=r(3788),w=r(3221),y=function(){var t=this,e=t._self._c;return e("div",{staticClass:"for-content"},[e("el-card",[e("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData}},[e("el-table-column",{attrs:{prop:"qq_id",label:"id",width:"180"}}),e("el-table-column",{attrs:{prop:"qq_robot",label:"机器人qq号",width:"180"}}),e("el-table-column",{attrs:{prop:"qq_robot_password",label:"密码"}}),e("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(r){return[e("el-switch",{attrs:{"active-value":1,"inactive-value":0},model:{value:r.row.val,callback:function(e){t.$set(r.row,"val",e)},expression:"scope.row.val"}})]}}])}),e("el-table-column",{attrs:{label:"设置"}},[e("el-link",{attrs:{type:"primary"}},[t._v("主要链接")])],1)],1)],1)],1)},k=[],x={data(){return{tableData:[{qq_id:"1",qq_robot:"王小虎",val:1,qq_robot_password:"123131231"},{qq_id:"2",qq_robot:"王小虎",val:1,qq_robot_password:"1123123123123123123"},{qq_id:"3",qq_robot:"王小虎",val:0,qq_robot_password:"24123413241"},{qq_id:"4",qq_robot:"王小虎",val:1,qq_robot_password:"897sdfaasf"},{qq_id:"1",qq_robot:"王小虎",val:1,qq_robot_password:"123131231"},{qq_id:"2",qq_robot:"王小虎",val:1,qq_robot_password:"1123123123123123123"},{qq_id:"3",qq_robot:"王小虎",val:0,qq_robot_password:"24123413241"},{qq_id:"4",qq_robot:"王小虎",val:1,qq_robot_password:"897sdfaasf"}]}},watch:{"this.tableData.val":function(t,e){console.log(t)}}},C=x,$=(0,s.Z)(C,y,k,!1,null,null,null),Z=$.exports,O={name:"forward",data(){return{userid:this.$route.params.userId}},components:{Tab:w.Z,Hand:q.Z,Forward_contentVue:Z}},T=O,F=(0,s.Z)(T,g,_,!1,null,null,null),I=F.exports,S=function(){var t=this,e=t._self._c;return e("div",{staticClass:"about"},[e("Hand"),e("Tab",{attrs:{id:t.userid}}),e("Echarts")],1)},j=[],P=r(2196),E={data(){return{userid:this.$route.params.userId}},components:{Tab:w.Z,Echarts:P.Z,Hand:q.Z}},H=E,W=(0,s.Z)(H,S,j,!1,null,null,null),B=W.exports,A=function(){var t=this,e=t._self._c;return e("div",{staticClass:"infor"},[e("Hand"),e("Tab",{attrs:{id:t.userid}})],1)},D=[],L={data(){return{userid:this.$route.params.userId}},components:[q.Z,w.Z]},M=L,N=(0,s.Z)(M,A,D,!1,null,null,null),V=N.exports;o["default"].use(c.ZP);const R=[{path:"/",name:"home",component:b},{path:"/about",name:"about",component:()=>r.e(443).then(r.bind(r,9830))},{path:"/forward",name:"forward",component:I},{path:"/echarts",name:"echarts",component:B},{path:"/infor",name:"infor",component:V}],z=new c.ZP({mode:"history",base:"/",routes:R});var X=z;o["default"].use(p.ZP);var G=new p.ZP.Store({state:{},getters:{},mutations:{},actions:{},modules:{}}),J=r(8499),K=r.n(J),Q=r(8548);o["default"].prototype.$echarts=Q,o["default"].config.productionTip=!1,o["default"].use(K()),new o["default"]({router:X,store:G,render:t=>t(u)}).$mount("#app")}},e={};function r(o){var n=e[o];if(void 0!==n)return n.exports;var a=e[o]={exports:{}};return t[o](a,a.exports,r),a.exports}r.m=t,function(){var t=[];r.O=function(e,o,n,a){if(!o){var s=1/0;for(c=0;c<t.length;c++){o=t[c][0],n=t[c][1],a=t[c][2];for(var l=!0,i=0;i<o.length;i++)(!1&a||s>=a)&&Object.keys(r.O).every((function(t){return r.O[t](o[i])}))?o.splice(i--,1):(l=!1,a<s&&(s=a));if(l){t.splice(c--,1);var u=n();void 0!==u&&(e=u)}}return e}a=a||0;for(var c=t.length;c>0&&t[c-1][2]>a;c--)t[c]=t[c-1];t[c]=[o,n,a]}}(),function(){r.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return r.d(e,{a:e}),e}}(),function(){r.d=function(t,e){for(var o in e)r.o(e,o)&&!r.o(t,o)&&Object.defineProperty(t,o,{enumerable:!0,get:e[o]})}}(),function(){r.f={},r.e=function(t){return Promise.all(Object.keys(r.f).reduce((function(e,o){return r.f[o](t,e),e}),[]))}}(),function(){r.u=function(t){return"js/about.a76b7e44.js"}}(),function(){r.miniCssF=function(t){}}(),function(){r.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(t){if("object"===typeof window)return window}}()}(),function(){r.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)}}(),function(){var t={},e="qqrobot:";r.l=function(o,n,a,s){if(t[o])t[o].push(n);else{var l,i;if(void 0!==a)for(var u=document.getElementsByTagName("script"),c=0;c<u.length;c++){var d=u[c];if(d.getAttribute("src")==o||d.getAttribute("data-webpack")==e+a){l=d;break}}l||(i=!0,l=document.createElement("script"),l.charset="utf-8",l.timeout=120,r.nc&&l.setAttribute("nonce",r.nc),l.setAttribute("data-webpack",e+a),l.src=o),t[o]=[n];var f=function(e,r){l.onerror=l.onload=null,clearTimeout(p);var n=t[o];if(delete t[o],l.parentNode&&l.parentNode.removeChild(l),n&&n.forEach((function(t){return t(r)})),e)return e(r)},p=setTimeout(f.bind(null,void 0,{type:"timeout",target:l}),12e4);l.onerror=f.bind(null,l.onerror),l.onload=f.bind(null,l.onload),i&&document.head.appendChild(l)}}}(),function(){r.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})}}(),function(){r.p="/"}(),function(){var t={143:0};r.f.j=function(e,o){var n=r.o(t,e)?t[e]:void 0;if(0!==n)if(n)o.push(n[2]);else{var a=new Promise((function(r,o){n=t[e]=[r,o]}));o.push(n[2]=a);var s=r.p+r.u(e),l=new Error,i=function(o){if(r.o(t,e)&&(n=t[e],0!==n&&(t[e]=void 0),n)){var a=o&&("load"===o.type?"missing":o.type),s=o&&o.target&&o.target.src;l.message="Loading chunk "+e+" failed.\n("+a+": "+s+")",l.name="ChunkLoadError",l.type=a,l.request=s,n[1](l)}};r.l(s,i,"chunk-"+e,e)}},r.O.j=function(e){return 0===t[e]};var e=function(e,o){var n,a,s=o[0],l=o[1],i=o[2],u=0;if(s.some((function(e){return 0!==t[e]}))){for(n in l)r.o(l,n)&&(r.m[n]=l[n]);if(i)var c=i(r)}for(e&&e(o);u<s.length;u++)a=s[u],r.o(t,a)&&t[a]&&t[a][0](),t[a]=0;return r.O(c)},o=self["webpackChunkqqrobot"]=self["webpackChunkqqrobot"]||[];o.forEach(e.bind(null,0)),o.push=e.bind(null,o.push.bind(o))}();var o=r.O(void 0,[998],(function(){return r(9205)}));o=r.O(o)})();
//# sourceMappingURL=app.02cb2605.js.map