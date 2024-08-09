document.addEventListener('DOMContentLoaded', function() {

	var menu = document.getElementById('menu');
	var button = document.getElementById('menuToggle');
	var iconMenu = document.getElementById('iconMenu');

	function toggleMenu() {
		
		var isMenuHidden = menu.classList.contains('hide');

		if (isMenuHidden) {
			
			menu.classList.remove('hide');
			menu.classList.add('show');
			iconMenu.classList.remove('rotate-right');
			button.style.background = '#FFD700';
			button.style.color = '#000033';
			
		} else {
			
			menu.classList.remove('show');
			menu.classList.add('hide');
			iconMenu.classList.add('rotate-right');
			button.style.background = '#32CD32';
			button.style.color = '#000033';			
			
		}
		
	}
	
	button.addEventListener('click', toggleMenu);

});