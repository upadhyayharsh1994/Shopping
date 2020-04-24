$(function() {


$(document).on('click', '#plus', function(e) {
    e.preventDefault();
    var priceValue = parseInt($('#priceValue').val());
    var quantity = parseInt($('#quantity').val());

    priceValue += parseInt($('#priceHidden').val());
    quantity += 1;

    $('#quantity').val(quantity);
    $('#priceValue').val(priceValue);
    $('#total').html(quantity);
  });


  $(document).on('click', '#minus', function(e) {
    e.preventDefault();
    var priceValue = parseInt($('#priceValue').val());
    var quantity = parseInt($('#quantity').val());


    if (quantity == 1) {
      priceValue = $('#priceHidden').val();
      quantity = 1;
    } else {
      priceValue -= parseInt($('#priceHidden').val());
      quantity -= 1;
    }

    $('#quantity').val(quantity);
    $('#priceValue').val(priceValue);
    $('#total').html(quantity);
  });
  
  });