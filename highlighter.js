const codes = document.getElementsByTagName("code");

function encase(args, color) {
    for (let arg of args) {
        const ele = document.createElement.innerHTML = `<color class=${color}>${arg}</color>`
        for (let code of codes) {
                code.innerHTML = code.innerHTML.replace(arg, ele);
        }
    }
}

function regexToArray(args) {
    array = [];
    for (let arg of args) {
        for (let code of codes) {
            temp = code.innerHTML.replace(arg, (arg) => {
                array.push(arg);
            })
        }
    }
    return (new Set(array));
}

function highlighter() {
    encase(["true", "false"], "blue");
    encase(["if", "else", "for", "while"], "red");
    encase(["new"], "red");
    encase(regexToArray([/(?<=\.)(.*?)(?=\()/]), "purple");
    encase(regexToArray([/[0-9]/]), "blue");
}