mainLink = document.getElementsByClassName("main-link");
function toggleResponsive() {
    for (i=0; i<mainLink.length; i++) {
        mainLink[i].classList.toggle("main-link-responsive");
    }
    setTimeout(() => {barTitle[0].classList.toggle("bar-title-responsive")}, 100)
}

function blink(id) {
    let ele = document.getElementById(id);
    ele.classList.toggle("blue-bg");
    setTimeout(() => { ele.classList.toggle("blue-bg") }, 200);
}