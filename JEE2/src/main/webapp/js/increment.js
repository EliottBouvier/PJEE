function addIncrement(text) {
	var value = document.getElementById("num-" + text.id).innerHTML;
	var valueInt = parseInt(value) + 1;
	document.getElementById("num-" + text.id).innerHTML = valueInt;
	document.getElementById("quantity-" + text.id).setAttribute("value", valueInt);
}

function removeIncrement(text) {
	var value = document.getElementById("num-" + text.id).innerHTML;
	var valueInt = parseInt(value);
	if(valueInt > 1) {
		valueInt = parseInt(value) - 1;
		document.getElementById("num-" + text.id).innerHTML = valueInt;
		document.getElementById("quantity-" + text.id).setAttribute("value", valueInt);
	}
}