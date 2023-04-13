Vue
	.createApp({
		data() {
			return {
				test: "hello",
				list: [],
				isShowRegForm: true,
				menu: { name: "aaa", price: 0 }
			};
		},
		methods: {
			menuSaveHandler() {
				var myHeaders = new Headers();
				myHeaders.append("Content-Type", "application/json");

				var raw = JSON.stringify(this.menu);

				var requestOptions = {
					method: 'POST',
					headers: myHeaders,
					body: raw,
					redirect: 'follow'
				};

				fetch("http://localhost:8080/admin/menu/reg", requestOptions)
					.then(response => response.text())
					.then(result => {
						if(result==="ok")
							this.load();
					})
					.catch(error => console.log('error', error));
			},
			menuAddHandler() {
				this.isShowRegForm = !this.isShowRegForm;
			},
			categoryClickHandler(e) {
				//			this.load(e.target.dataset.id, function(){
				//				console.log("데이터가 도착했니?");
				//			});				

				this.list.push({ id: 4, name: "디카페인 아메리카노", price: 5500 });

				//this.load(2);
				// 데이터를 요청하고 그 요청이 도착하면 할일이 여기에 있는거야..
				// 근데...ㅜㅜ 도착하기 전에 실행되는 ....아 ..증말..

			},
			load() {

				//fetch("/menus", (response)=>{/* 결과 후에 실행할 코드 */});

				fetch("/menus")
					.then(response => {
						return response.json();
					})
					.then(list => {
						this.list = list;
					})
					.catch(error => {
						console.log("aaaa");
					});

				/*
				promise.then(response=>{
					let promise = response.json();
					promise.then(list=>{
						console.log(list);
					});
				});*/


				//			let response = await fetch("/menus");
				//			let list = await response.json();
				//			console.log(list);			

				//XHR(XmlHttpRequest)
				//-Callback을 이용한 비동기처리
				//Fetch API
				//-Promise를 이용한 비동기처리
			}
		},
		beforeCreate() { console.log("beforeCreate") },
		created() { console.log("created") },
		beforeMount() { console.log("beforeMount") },
		mounted() {
			console.log("mounted");
			this.load();
		},
		beforeUpdate() { console.log("beforeUpdate") },
		updated() { console.log("updated") },
		beforeUnmount() { console.log("beforeUnmount") },
		unmounted() { console.log("unmounted") }

	})
	.mount("#main-section");