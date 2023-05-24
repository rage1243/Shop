let timer1, timer2;

console.log(document.getElementById("link_more_clock"))

const toast = document.querySelector(".toast");
const closeIcon = document.querySelector(".close");
const progress = document.querySelector(".progress");
const element = document.getElementById("link_more_clock");

function addEventListener() {
    if (element != null) element.addEventListener('click', wrapper);
    closeIcon.addEventListener("click", () => {
        toast.classList.remove("active");
        toast.setAttribute('style', "visibility: hidden;")

        setTimeout(() => {
            progress.classList.remove("active");
        }, 300);

        clearTimeout(timer1);
        clearTimeout(timer2);
    });
}

function wrapper() {
    toast.setAttribute('style', "visibility: visible;")
    toast.classList.add("active");
    progress.classList.add("active");

    console.log("click");

    timer1 = setTimeout(() => {
        toast.classList.remove("active");
    }, 5000); //1s = 1000 milliseconds

    timer2 = setTimeout(() => {
        progress.classList.remove("active");
    }, 5300);
}

window.onload = function() {
    addEventListener()
}