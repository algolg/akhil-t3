bar = document.getElementsByClassName("bar");
barTitle = document.getElementsByClassName("bar-title");
mainLink = document.getElementsByClassName("main-link");
function toggleResponsive() {
    barTitle[0].classList.toggle("bar-title-display");
    bar[0].classList.toggle("top-responsive");
    for (i=0; i<mainLink.length; i++) {
        mainLink[i].classList.toggle("main-link-responsive");
    }
    setTimeout(() => {barTitle[0].classList.toggle("bar-title-responsive")}, 100)
}