document.addEventListener("DOMContentLoaded", function(){
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    let submit = document.getElementById("submit");
    
    submit.addEventListener("click", async function(e){
        e.preventDefault();
        const data = {
            "username":username.value,
            "password":password.value,
        }
        try{
            const resp = await fetch("/api/login",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify(data)
            })
            
            let response = await resp.json();
            console.log(response);
            username.value = "";
            password.value = "";
            
        }catch(error){
            console.log(error);
        }
    })
    
})