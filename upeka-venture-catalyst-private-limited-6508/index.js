function goGet(url){
    fetch(url).then((res)=>
    res.json()
).then((res)=>{
    console.log(res) ;
}).catch((e)=>{
    console.log(e);
})

}


function runAt10am() {
    var now = new Date();
    let url = "https://script.google.com/macros/s/AKfycbx8BOoN6E0sjTBJ6ELMu-rF6hKTox0faRHBNAw11vBTn49rsJc9bBnIWnUHDxEEMhqBFg/exec";

    if (now.getHours() === 10 && now.getMinutes() === 0) {
        
         goGet(url);
    }

 }

 let url = "https://script.google.com/macros/s/AKfycbx8BOoN6E0sjTBJ6ELMu-rF6hKTox0faRHBNAw11vBTn49rsJc9bBnIWnUHDxEEMhqBFg/exec";

 fetch(url).then((res)=>
        res.json()
    ).then((res)=>{
        console.log(res) ;
    }).catch((e)=>{
        console.log(e);
    })


  runAt10am();

 



