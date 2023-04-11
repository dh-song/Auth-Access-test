window.addEventListener("load", function(){
	const menuList = document.querySelector(".menu-list");
	let ul = document.querySelector(".menu-category>ul");
	const form = document.querySelector(".search-header form");
	const findButton = form.querySelector(".icon-find");
	console.log(findButton);
	
	findButton.onclick = function(e){
		e.preventDefault();
		
		const queryInput = form.querySelector("input[name=q]");
		let query = queryInput.value;
		
		const request = new XMLHttpRequest();
		request.onload = function(){
			let menus = JSON.parse(request.responseText);
			
			bind(menus);
		}
		request.open("GET", `http://localhost:8080/menus?q=${query}`, true); // 브라우저에서 url을 입력하는 것과 같은 요청정보 입력
		request.send();
	}	
	
	ul.onclick = function(e){
		e.preventDefault();
		let tagName = e.target.tagName;
		
		//if(!(tagName == 'LI' || tagName == 'A')
		if(tagName != 'LI' && tagName != 'A') // li가 아니면 return;
			return;
		
		// 데이터 수집을 해야 함
		let elLi = (tagName === 'LI')?e.target:e.target.parentNode;
		//elLi.className = "menu-selected";
		
		let curLi = ul.querySelector("li.menu-selected");
		if(curLi === elLi)
			return;
		
		curLi.classList.remove("menu-selected");	
		elLi.classList.add("menu-selected");			
	
		
		console.log(elLi.dataset.cid);
		
		let categoryId=elLi.dataset.cid;
		
		const request = new XMLHttpRequest();
		request.onload = function(){
			let menus = JSON.parse(request.responseText);
			
			bind(menus);
						
		};
		request.open("GET", `http://localhost:8080/menus?c=${categoryId}`, true); // 브라우저에서 url을 입력하는 것과 같은 요청정보 입력
		request.send();
		
		
		
		
		
		//=== Fetch API =======================================
		/*
		var requestOptions = {
		  method: 'GET',
		  redirect: 'follow'
		};
		
		fetch("http://localhost:8080/menus/617", requestOptions)
		  .then(response => response.text())
		  .then(result => console.log(result))
		  .catch(error => console.log('error', error));
		
		//=== XHR(XmlHttpRequest) =====================================
		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;
		
		xhr.addEventListener("readystatechange", function() {
		  if(this.readyState === 4) {
		    console.log(this.responseText);
		  }
		});
		
		xhr.open("GET", "http://localhost:8080/menus/617");
		
		xhr.send();	
		*/
		
	};	
	
	function bind(menus){
		// 기존 목록을 모두 지우고
		// 목록을 지우는 방법 1:
		//menuList.children[0].remove();
		//menuList.firstElementChild.remove();
		//menuList.removeChild(menuList.firstElementChild);
		//while(menuList.firstElementChild)
		//	menuList.firstElementChild.remove();
		
		// 목록을 지우는 방법 2:
		//menuList.textContent = "<span style='blue';>test hello</span>";
		//menuList.innerText = "<span style='blue';>test hello</span>";
		//menuList.innerHTML = "<span style='color:blue;'>test hello</span>";
		menuList.innerHTML = "";
		
		// 목록을 만들어 채우기
		// 방법 1 : DOM 객체를 직접 생성해서 채우기
        
		let menuSection = document.createElement("section");
		menuSection.className = "menu";
		
		let form = document.createElement("form");
		form.className="";
		
		//menuSection.appendChild(form); // Node interface의 기능
		menuSection.append(form); 		// Element interface의 기능			
		//menuList.append(menuSection);
		
		// 방법 2 : 문자열을 이용한 객체 생성
		
		for(let m of menus){
			let template = `<section class="menu">
	                <form class="">
	                    <h1><span>${m.name}</span>/<span style="font-size:11px;">커피음료</span></h1> 
	                    <div class="menu-img-box">
	                        <a href="detail?id=${m.id}"><img class="menu-img" src="/image/menu/${m.img}"></a>
	                    </div>
	                    <div class="menu-price">${m.price} 원</div>
	                    <div class="menu-option-list">
	                        <span class="menu-option">
	                            <input class="menu-option-input" type="checkbox">
	                            <label>ICED</label>
	                        </span>            
	                        <span class="menu-option ml-2">
	                            <input class="menu-option-input" type="checkbox">
	                            <label>Large</label>
	                        </span>
	                    </div>
	                    <div class="menu-button-list">
	                        <input class="btn btn-fill btn-size-1 btn-size-1-lg" type="submit" value="담기">
	                        <input class="btn btn-line btn-size-1 btn-size-1-lg ml-1" type="submit" value="주문하기">
	                    </div>
	                </form>
	            </section>`;
	      	//menuList.innerHTML += template;
	      	menuList.insertAdjacentHTML("beforeend", template);
		}		            
	}
});