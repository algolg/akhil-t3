const codes = document.getElementsByTagName("code");

function encase(args, color) {
    const ele = document.createElement.innerHTML =   `<color class=${color}>${arg}</color>`
    for (let code of codes) {
        for (let arg of args) {
            code.innerHTML = code.innerHTML.replace(arg, ele);
        }
    }
}

function highligher() {
    encase(["true"], "blue");
    encase(["if", "else", "for", "while"], "red");
    encase(["new"], "red");
}