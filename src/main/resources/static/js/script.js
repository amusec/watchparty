document.addEventListener("DOMContentLoaded",function(){
    let username = document.getElementById("username")
    let password = document.getElementById("password")
    let email = document.getElementById("email")
    let submit = document.getElementById("submit")
    
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

            const result = await response.text();
            console.log(result);
        } catch(error){
            console.log(error)
        }
        
        
        
    })
    
})