// login.js
function enroll() {
    fetch("http://localhost:8080/enroll", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({})
})

   .then(response => {
        if (response.ok) {
            alert("Successfull");
            window.location.href="interview.html"
            
        }else{
            return response.json().then(data=>{throw new Error(data.message || "FAILED")});
        }
   
}).catch(error =>{
    alert(error.message);
})


}

function login() {
        const name=document.getElementById("name").value;
        const email=document.getElementById("email").value;
 

    fetch("http://localhost:8080/interview", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({name,email})
})

    .then(response => {
        if (response.ok) {
            alert("Login Successfull");
            window.location.href="interview.html"
            
        }else{
            return response.json().then(data=>{throw new Error(data.message || "FAILED")});
        }
   
}).catch(error =>{
    alert(error.message);
})


}

