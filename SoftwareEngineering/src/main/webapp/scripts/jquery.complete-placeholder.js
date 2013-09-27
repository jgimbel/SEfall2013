// License: MIT (http://www.opensource.org/licenses/mit-license.php)
// Shout-outs to open source software, Soul Control Crew International, & real Hip Hop. 
// Copyright 2011 Babak Badaei (http://www.thoughtswordsdeeds.com)


(function($){
$.fn.placeholder = function(options)
	{
		msie = (jQuery.browser.msie) ? true : false;
		
		// configurations
		setup = 
		{
				'set_class'  	: true,
				'class_name' 	: 'placeholder',
				'skip'  		: false,
				'ie_submit_swap' : true, // If fallback validation isn't working in IE try setting to true.
				'ie_password_callback' : '' // Provide callback function for custom ie password submit validation. Another IE fallback validation workaround.
				
		}
		
		// register
		if(options)
			$.extend(setup,options)	

		var objects = {}
		var alt_objects = {}

		$(this).data('placeholder',setup)
		
		/*if(options['skip'] == true)
		{
			return this
		}*/
		// our variables
		var submit_swap = setup['ie_submit_swap']
		var callback = setup['ie_password_callback']
		var set_placeholder_class = setup['set_class'];
		var placeholder_class_name = setup['class_name'];
		var sample_input = document.createElement('input')
		var do_placeholders = ('placeholder' in sample_input) ? false : true;
		// our functions
		function swap_to_password(obj) 
		{
			if(!alt_objects[obj.name])
				alt_objects[obj.name] = obj

			$(obj).removeClass(placeholder_class_name)
			try{obj.setAttribute('type', 'password');}
			catch(e)
			{
				// For IE, we have to use the black arts.
				$(obj).attr('_placeholder_internal','true')
				$(obj).val('')
		 		replaced = $(obj.parentNode).html().replace(/type[ ]*=[ ]*(["']{0,1})[_ ]*text/i, 'type=$1password');
				rendered = $(obj.parentNode).html(replaced)
				
				obj = $('[_placeholder_internal]')
				//obj.removeAttr('_placeholder_internal')
			}
			return obj
		}
		
		function pre_swap_to_password(obj)
		{
			input = $(obj)
			input.focus(function()
			{
				$(obj).val('')
				newo = swap_to_password(obj)

				if(msie)
				{
					$(newo).focus()
					newo.focus() // IE needs this. Twice.
				}

				$(newo).blur(function()
				{						
					if(!$(this).val() || $(this).val() == $(this).attr('placeholder'))
					{
						var input = $(this)
						input.val(input.attr('placeholder'))
						input.addClass(placeholder_class_name)
						swap_to_text(this);
					}
				})
			})
		}
						
		function swap_to_text(obj) 
		{
			$(obj).attr('passwordcache','true')

			//if(!objects[obj.name])
			//	objects[obj.name] = obj
			try{obj.setAttribute('type', 'text');}
			catch(e)
			{
				// More IE babysitting
		 		replaced = $(obj.parentNode).html().replace(/type[ ]*=[ ]*(["']{0,1})[_ ]*password/i, 'type=$1text');
				rendered = $(obj.parentNode).html(replaced)
			}
			/* IE loses scope of obj once type is changed so we have to re-discover our password fields */
			$('[passwordcache]').each(function()
			{
				var input = $(this)
				input.addClass(placeholder_class_name)
				if(! (input.val())) input.val(input.attr('placeholder'))
				pre_swap_to_password(this)
				return this			
			})
		}
		
		function placeholder_off(obj)
		{
			var input = $(obj);
			
			if (input.val() == input.attr('placeholder')) 
			{
				if(do_placeholders) input.val('');
			}
			if(set_placeholder_class) input.removeClass(placeholder_class_name);
			return obj
		}
		
		function placeholder_on(obj)
		{
			var input = $(obj);
			if (input.val() == '' || input.val() == input.attr('placeholder')) 
			{
				//no this one
				if(do_placeholders) input.val(input.attr('placeholder'));
				if(set_placeholder_class) input.addClass(placeholder_class_name);
			}
		}
		// our directives
		$(this).ready(function()
		{
			if(do_placeholders || set_placeholder_class)
			{
				$('[placeholder]').focus(function(){placeholder_off(this)}).blur(function(){placeholder_on(this)});
				$('[placeholder]').blur();
		
				if(do_placeholders)$(':submit').click(function()
				{

					$(this).parents('form').find('[placeholder]').each(function() 
					{
						var input = $(this);
						if (input.val() == input.attr('placeholder')) 
							input.val('');
						
						$('[passwordcache]').focus(function(){placeholder_off(this)}).blur(function(){placeholder_on(this)});
						
					});
					
								// Swap back the textfield on submit and put value there
								if(msie) $('[passwordcache]').each(function(){
									if(alt_objects[this.name])
									{
										if((callback && !eval(callback+'(this.value)')))
											return false
										if(submit_swap)
										{
											if(this.value == '' )
												$(alt_objects[this.name]).val('')
											else
												$(alt_objects[this.name]).val(this.value)
											$(alt_objects[this.name]).focus(function(){swap_to_password(this)}).blur(function(){swap_to_text(this)})
											this.parentNode.replaceChild(alt_objects[this.name],this)
										}

									}
								})
					
				});

				if(do_placeholders)
					$(':password[placeholder]').each(function(){swap_to_text(this)})
			}
		})
		return this
	}
})(jQuery);

$(document).ready(function()
{
	// if user has not configured settings & executed, automatically execute with defaults
	
	if(!$(this).data('placeholder'))
		$(this).placeholder({})
})
