function showAnswer(i) {
    var state = document.getElementsByClassName('answer')[i];
    if (state.style.display == 'none') {
        state.style.display = 'block';
        document.getElementsByClassName('h4-answer')[i].style.display = 'block';
    } else {
        state.style.display = 'none';
        document.getElementsByClassName('h4-answer')[i].style.display = 'none';
    }
}


function showBoxAnswer(i){
    var state = document.getElementsByClassName('answer')[i];
    if (state.style.display == 'none') {
        state.style.display = 'block';
    } else {
        state.style.display = 'none';
    }
}