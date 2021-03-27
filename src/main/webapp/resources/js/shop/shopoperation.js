/**
 * 
 */
$(function(){
	var initUrl = '/O2O/shopadmin/getshopinitinfo';
	var registerShopUrl = '/O2O/shopadmin/registershop';
	getShopInitInfo();
	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {
			if(data.success){
				var tempHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item, index){
					tempHtml += '<option data-id="'+item.shopCategoryId+'">'
					+item.shopCategoryName + '</option>';
				});
				data.areaList.map(function(item, index){
					tempAreaHtml += '<option data-id="' + item.area_id + '">' 
					+item.area_name + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#shop-area').html(tempAreaHtml);
				
			}
		});
		
		$('#submit').click(function(){
			var shop = {};
			shop.shopName = $('#shop-name').val();
			shop.shopAddr = $('#shop-addr').val();
			shop.phone = $('#shop-phone').val();
			shop.shopDesc = $('shop-desc').val();
			shop.shopCategory = {
					shopCategoryId:$('#shop-category').find('option').not(function(){
						return !this.selected;
					}).data('id')
			}
			shop.area = {
					areaId:$('#shop-area').find('option').not(function(){
						return !this.selected
					}).data('id')
			};
			var shopImg = $('#shop-img')[0].files[0];
			var formData = new FormData();
			formData.append('shopImg', shopImg);
			formData.append('shopStr', JSON.stringify(shop));
			var verifyCodeActual = $('#j-captcha').val();
			if (!verifyCodeActual) {
				$.toast('Please Input Verification Code');
				return;
			}
			formData.append('verifyCodeActual', verifyCodeActual);
			$.ajax({
				url:registerShopUrl,
				type:'POST',
				data: formData,
				contentType:false,
				processData: false,
				cache:false,
				success:function(data){
					if (data.success){
						$.toast('submit success !');
					} else {
						$.toast('submit failed!' + data.errMsg);
					}
					$('#captcha-img').click();
				}
			});
		});
	}
})