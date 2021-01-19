$(document).ready(function () {
	$('.item__head').click(function () {
		$(this).parent().toggleClass('top__item_active')
	});
	$('.item__head').click(function (e) {
		$(this).parent().toggleClass('aside__item_active')
	})
})