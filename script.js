const selectEl = document.getElementById('select');
const button = document.querySelector('.form-submit-button');
let formListenerName = 0, formListenerPhone= 0;
let formName = document.getElementById("name"), formPhone= document.getElementById("phone");


// REST



// Після того, як підключите локальний сервер
fetch('http://localhost:3000/pizzas')
    .then((response) => response.json())
    .then((json) => {
        newOptions = json;
       newOptions.forEach(option => {
           return createNewOption(option.value, option.title)
        })
    });

 function createNewOption(value,title) {
    let createdOption = document.createElement("option");
    createdOption.innerText = title;
     createdOption.value = value;
     appendOption(createdOption);
 }

 function appendOption(option) {
     selectEl.append(option);
 }


 formName.addEventListener("input", function(){ 
    if (!formName.value){
        buttonClick(formListenerName = 0);
    } else {
        console.log('Name');
        buttonClick(formListenerName = 1);
    }
})

formPhone.addEventListener("input", function(){
    if (!formPhone.value){
        buttonClick(formListenerPhone = 0);
    } else {
        console.log('Phone');
        buttonClick(formListenerPhone = 1);
    }
})

function buttonClick(){
    if (formListenerName == 1 && formListenerPhone == 1){
        console.log('Button works!')
        document.getElementById("formButton").removeAttribute("disabled");
        document.getElementById("formButton").style.backgroundColor = "#30C598";
        document.getElementById("formButtonLink").style.pointerEvents = "unset"
    }
    if(formListenerName == 0 || formListenerPhone == 0) {
        document.getElementById("formButton").setAttribute("disabled", "disabled");
        document.getElementById("formButton").style.backgroundColor = "#AEDBCE";
        document.getElementById("formButtonLink").style.pointerEvents = "none"
    }
}


