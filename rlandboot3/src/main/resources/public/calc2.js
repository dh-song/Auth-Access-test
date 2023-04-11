Vue
.createApp({
	data(){
		let x = 30;
		let y = 50;
		let z = 0;
		
		return {x, y, z};
	},
	methods:{
		calcHandler(e){
			this.z = this.x+this.y;
						
		},
		resetHandler(e){			
			console.log("reset");
		}			
	}
})
.mount("#calc");