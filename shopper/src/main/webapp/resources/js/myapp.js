$(function() {

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Login':
		$('#login').addClass('active');
		break;

	case 'My Product':
		$('#viewproducts').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
	}
});