document.addEventListener("DOMContentLoaded",function(){
    let username = document.getElementById("username")
    let password = document.getElementById("password")
    let email = document.getElementById("email")
    let submit = document.getElementById("submit")
    let message = document.getElementById("message")
    
    submit.addEventListener("click", async function(e){
        e.preventDefault();
        
        const data = {
            username: username.value,
            password:password.value,
            email:email.value
        }
        try{
            const response = await fetch("/api/register",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },body: JSON.stringify(data)
            });

            const result = await response.json();
            if(result.success){
                message.className = "success";
            }else{
                message.className = "error"
            }
                message.innerText = result.message;
        } catch(error){
            console.log(error)
        }
        
        
        
    })
    
})