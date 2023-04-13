<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/views/common/header.jsp">
    <jsp:param value="홈페이지" name="title"/>
</jsp:include>

<body style="padding-top: 72px;">

<div class="container py-5">
    <div class="row">
        <div class="col-lg-7">
            <div class="text-block">
                <div class="row gallery mb-3 ms-n1 me-n1">
                    <div class="col-lg-12 col-6 px-1 mb-2 d-flex justify-content-center align-items-center">
                        <a href="img/photo/sample1.PNG" data-fancybox="gallery" title="Our street">
                            <img class="img-fluid" src="img/photo/sample1.PNG" alt="...">
                        </a>
                    </div>
                    <div class="col-lg-4 col-6 px-1 mb-2"><a href="img/photo/photo-1512917774080-9991f1c4c750.jpg" data-fancybox="gallery" title="Outside"><img class="img-fluid" src="img/photo/photo-1512917774080-9991f1c4c750.jpg" alt="..."></a></div>
                    <div class="col-lg-4 col-6 px-1 mb-2"><a href="img/photo/photo-1494526585095-c41746248156.jpg" data-fancybox="gallery" title="Rear entrance"><img class="img-fluid" src="img/photo/photo-1494526585095-c41746248156.jpg" alt="..."></a></div>
                    <div class="col-lg-4 col-6 px-1 mb-2"><a href="img/photo/photo-1494526585095-c41746248156.jpg" data-fancybox="gallery" title="Rear entrance"><img class="img-fluid" src="img/photo/photo-1494526585095-c41746248156.jpg" alt="..."></a></div>
                    <!-- <div class="col-lg-4 col-6 px-1 mb-2"><a href="img/photo/photo-1484154218962-a197022b5858.jpg" data-fancybox="gallery" title="Kitchen"><img class="img-fluid" src="img/photo/photo-1484154218962-a197022b5858.jpg" alt="..."></a></div> -->
                    <!-- <div class="col-lg-4 col-6 px-1 mb-2"><a href="img/photo/photo-1522771739844-6a9f6d5f14af.jpg" data-fancybox="gallery" title="Bedroom"><img class="img-fluid" src="img/photo/photo-1522771739844-6a9f6d5f14af.jpg" alt="..."></a></div>
                    <div class="col-lg-4 col-6 px-1 mb-2"><a href="img/photo/photo-1488805990569-3c9e1d76d51c.jpg" data-fancybox="gallery" title="Bedroom"><img class="img-fluid" src="img/photo/photo-1488805990569-3c9e1d76d51c.jpg" alt="..."></a></div> -->
                </div>
            </div>
        </div>
        <div class="col-lg-5">
            <div class="p-4 shadow ms-lg-4 rounded sticky-top" style="top: 100px;">
                <p  class="text-primary">New 프로모션 진행중</p>
                <p class><span class="text h1">정수기 이름</span> per night</p>
                <p  class="text-muted">품번</p>

                <hr class="my-4">
                <form class="form" id="booking-form" method="get" action="#" autocomplete="off">
                    <div class="mb-4">
                        <label class="form-label" for="bookingDate">Your stay *</label>
                        <div class="datepicker-container datepicker-container-right">
                            <input class="form-control" type="text" name="bookingDate" id="bookingDate" placeholder="Choose your dates" value ="water" required="required">
                        </div>
                    </div>
                    <div class="mb-4">
                        <label class="form-label" for="guests">Guests *</label>
                        <select class="form-control" name="guests" id="guests">
                            <option value="1">1 Guest</option>
                            <option value="2">2 Guests</option>
                            <option value="3">3 Guests</option>
                            <option value="4">4 Guests</option>
                            <option value="5">5 Guests</option>
                        </select>
                    </div>
                    <div class="row">
                        <a class="btn btn-primary d-grid mb-2"  href="../order/rental1">렌탈</a>
                        <button class="btn btn-primary d-grid mb-2" href="../order/user-booking-1.html">구매</button>
<%--                        <button class="btn btn-primary d-grid mb-2" type="submit">구매</button>--%>
                    </div>
                </form>
                <p class="text-muted text-sm text-center">Some additional text can be also placed here.</p>
                <hr class="my-4">
                <div class="text-center">
                    <p> <a class="text-secondary text-sm" href="#"> <i class="fa fa-heart"></i> Bookmark This Listing</a></p>
                    <p class="text-muted text-sm">79 people bookmarked this place </p>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="d-flex justify-content-lg-center align-items-center" style="background-color: black" id="detailBar">
    <ul class="d-flex my-3" style="color:white;">
        <li ><a class="detail-bar-item"  href="#detailInfo"><span data-index="0"  onclick="changeTextColor(this)">상세설명</span></a></li>
        <li ><a class="detail-bar-item" href="#buyingInfo"><span data-index="1"  onclick="changeTextColor(this)">구매정보</span></a></li>
        <li ><a class="detail-bar-item" href="#reviewContents"><span data-index="2" onclick="changeTextColor(this)">후기</span></a></li>
        <li ><a class="detail-bar-item" href="#inquireContents"><span data-index="3" onclick="changeTextColor(this)">문의</span></a></li>
    </ul>
</div>
<div class="pb-6 bg-gray-100">
    <div class="container pt-6" id="detailInfo">
        <div class="text-block">
            <p class="text-primary"><i class="fa-map-marker-alt fa me-1"></i> Brooklyn, New York</p>
            <h1>정수기 이름</h1>
            <p class="text-muted text-uppercase mb-4">Entire Apartment </p>
            <ul class="list-inline text-sm mb-4">
                <li class="list-inline-item me-3"><i class="fa fa-users me-1 text-secondary"></i> 4 guests</li>
                <li class="list-inline-item me-3"><i class="fa fa-door-open me-1 text-secondary"></i> 1 bedroom</li>
                <li class="list-inline-item me-3"><i class="fa fa-bed me-1 text-secondary"></i> 3 beds</li>
                <li class="list-inline-item me-3"><i class="fa fa-bath me-1 text-secondary"></i> 1 bath</li>
            </ul>
            <p class="text-muted fw-light">Our garden basement apartment is fully equipped with everything you need to enjoy your stay. Very comfortable for a couple but plenty of space for a small family. Close to many wonderful Brooklyn attractions and quick trip to Manhattan. </p>
            <h6 class="mb-3">The space</h6>
            <p class="text-muted fw-light">Welcome to Brooklyn! We are excited to share our wonderful neighborhood with you. Our modern apartment has a private entrance, fully equipped kitchen, and a very comfortable queen size bed. We are happy to accommodate additional guests with a single bed in the living room, another comfy mattress on the floor and can make arrangements for small children with a portable crib and highchair if requested. </p>
            <p class="text-muted fw-light">Also in the apartment:</p>
            <ul class="text-muted fw-light">
                <li>TV with Netflix and DirectTVNow</li>
                <li>Free WiFi</li>
                <li>Gourmet Coffee/Tea making supplies</li>
                <li>Fresh Sheets and Towels</li>
                <li>Toaster, microwave, pots and pans and basic cooking needs like salt, pepper, sugar, and olive oil.</li>
                <li>Air Conditioning to keep you cool all summer!</li>
            </ul>
            <p class="text-muted fw-light">The apartment is surprisingly quiet for being in the heart of a vibrant, bustling neighborhood.</p>
            <h6 class="mb-3">Interaction with guests</h6>
            <p class="text-muted fw-light">We live in the two floors above the garden apartment so we are usually available to answer questions. The garden apartment is separate from our living space. We are happy to provide advice on local attractions, restaurants and transportation around the city. If there's anything you need please don't hesitate to ask!</p>
        </div>
        <div class="text-block py-6" id="buyingInfo">
            <h4 class="mb-4">구매정보</h4>
            <div class="row">
                <div class="col-md-6">
                    <ul class="list-unstyled text-muted">
                        <li class="mb-2"> <i class="fa fa-wifi text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Wifi</span></li>
                        <li class="mb-2"> <i class="fa fa-tv text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Cable TV</span></li>
                        <li class="mb-2"> <i class="fa fa-snowflake text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Air conditioning</span></li>
                        <li class="mb-2"> <i class="fa fa-thermometer-three-quarters text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Heating</span></li>
                    </ul>
                </div>
                <div class="col-md-6">
                    <ul class="list-unstyled text-muted">
                        <li class="mb-2"> <i class="fa fa-bath text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Toiletteries</span></li>
                        <li class="mb-2"> <i class="fa fa-utensils text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Equipped Kitchen</span></li>
                        <li class="mb-2"> <i class="fa fa-laptop text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Desk for work</span></li>
                        <li class="mb-2"> <i class="fa fa-tshirt text-secondary w-1rem me-3 text-center"></i><span class="text-sm">Washing machine</span></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="text-block">
            <h4 class="mb-0">Amenities alternative</h4>
            <p class="subtitle text-sm text-primary mb-4">Alternative amenities display</p>
            <ul class="list-inline">
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Wifi</span></li>
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Cable TV</span></li>
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Air conditioning</span></li>
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Heating</span></li>
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Toiletteries</span></li>
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Equipped Kitchen</span></li>
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Desk for work</span></li>
                <li class="list-inline-item mb-2"><span class="badge rounded-pill bg-light p-3 text-muted fw-normal">Washing machine</span></li>
            </ul>
        </div>
        <div class="text-block py-6" id="reviewContents">
            <p class="subtitle text-sm text-primary">Reviews    </p>
            <h5 class="mb-4">Listing Reviews </h5>
            <div>
                <button class="btn btn-outline-primary" type="button" data-bs-toggle="collapse" data-bs-target="#leaveReview" aria-expanded="false" aria-controls="leaveReview">Leave a review</button>
                <div class="collapse mt-4" id="leaveReview">
                    <h5 class="mb-4">Leave a review</h5>
                    <form class="form" id="contact-form" method="get" action="#">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-4">
                                    <label class="form-label" for="name">Your name *</label>
                                    <input class="form-control" type="text" name="name" id="name" placeholder="Enter your name" required="required">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="mb-4">
                                    <label class="form-label" for="rating">Your rating *</label>
                                    <select class="form-select focus-shadow-0" name="rating" id="rating">
                                        <option value="5">&#9733;&#9733;&#9733;&#9733;&#9733; (5/5)</option>
                                        <option value="4">&#9733;&#9733;&#9733;&#9733;&#9734; (4/5)</option>
                                        <option value="3">&#9733;&#9733;&#9733;&#9734;&#9734; (3/5)</option>
                                        <option value="2">&#9733;&#9733;&#9734;&#9734;&#9734; (2/5)</option>
                                        <option value="1">&#9733;&#9734;&#9734;&#9734;&#9734; (1/5)</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label" for="email">Your email *</label>
                            <input class="form-control" type="email" name="email" id="email" placeholder="Enter your  email" required="required">
                        </div>
                        <div class="mb-4">
                            <label class="form-label" for="review">Review text *</label>
                            <textarea class="form-control" rows="4" name="review" id="review" placeholder="Enter your review" required="required"></textarea>
                        </div>
                        <button class="btn btn-primary" type="submit">Post review</button>
                    </form>
                </div>
            </div>
            <div class="d-flex d-block d-sm-flex review">
                <div class="text-md-center flex-shrink-0 me-4 me-xl-5"><img class="d-block avatar avatar-xl p-2 mb-2" src="img/avatar/avatar-8.jpg" alt="Padmé Amidala"><span class="text-uppercase text-muted text-sm">Dec 2018</span></div>
                <div>
                    <h6 class="mt-2 mb-1">Padmé Amidala</h6>
                    <div class="mb-2"><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i>
                    </div>
                    <p class="text-muted text-sm">One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections     </p>
                </div>
            </div>
            <div class="d-flex d-block d-sm-flex review">
                <div class="text-md-center flex-shrink-0 me-4 me-xl-5"><img class="d-block avatar avatar-xl p-2 mb-2" src="img/avatar/avatar-2.jpg" alt="Luke Skywalker"><span class="text-uppercase text-muted text-sm">Dec 2018</span></div>
                <div>
                    <h6 class="mt-2 mb-1">Luke Skywalker</h6>
                    <div class="mb-2"><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-gray-200"></i>
                    </div>
                    <p class="text-muted text-sm">The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked. &quot;What's happened to me?&quot; he thought. It wasn't a dream.     </p>
                </div>
            </div>
            <div class="d-flex d-block d-sm-flex review">
                <div class="text-md-center flex-shrink-0 me-4 me-xl-5"><img class="d-block avatar avatar-xl p-2 mb-2" src="img/avatar/avatar-3.jpg" alt="Princess Leia"><span class="text-uppercase text-muted text-sm">Dec 2018</span></div>
                <div>
                    <h6 class="mt-2 mb-1">Princess Leia</h6>
                    <div class="mb-2"><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-gray-200"></i><i class="fa fa-xs fa-star text-gray-200"></i>
                    </div>
                    <p class="text-muted text-sm">His room, a proper human room although a little too small, lay peacefully between its four familiar walls. A collection of textile samples lay spread out on the table.     </p>
                </div>
            </div>
            <div class="d-flex d-block d-sm-flex review">
                <div class="text-md-center flex-shrink-0 me-4 me-xl-5"><img class="d-block avatar avatar-xl p-2 mb-2" src="img/avatar/avatar-4.jpg" alt="Jabba Hut"><span class="text-uppercase text-muted text-sm">Dec 2018</span></div>
                <div>
                    <h6 class="mt-2 mb-1">Jabba Hut</h6>
                    <div class="mb-2"><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i><i class="fa fa-xs fa-star text-primary"></i>
                    </div>
                    <p class="text-muted text-sm">Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame.     </p>
                </div>
            </div>

        </div>
    </div>

</div>
<div class="bg-gray-100">
    <div class="container py-6" id="inquireContents">
        <h5 class="mb-0">Similar places</h5>
        <p class="subtitle text-sm text-primary mb-4">You may also like         </p>
        <!-- Slider main container-->
        <div class="swiper-container swiper-container-mx-negative swiper-init pt-3" data-swiper="{&quot;slidesPerView&quot;:4,&quot;spaceBetween&quot;:20,&quot;loop&quot;:true,&quot;roundLengths&quot;:true,&quot;breakpoints&quot;:{&quot;1200&quot;:{&quot;slidesPerView&quot;:3},&quot;991&quot;:{&quot;slidesPerView&quot;:2},&quot;565&quot;:{&quot;slidesPerView&quot;:1}},&quot;pagination&quot;:{&quot;el&quot;:&quot;.swiper-pagination&quot;,&quot;clickable&quot;:true,&quot;dynamicBullets&quot;:true}}">
            <!-- Additional required wrapper-->
            <div class="swiper-wrapper pb-5">
                <!-- Slides-->
                <div class="swiper-slide h-auto px-2" >
                    <!-- place item-->
                    <div class="w-100 h-100 hover-animate" data-marker-id="59c0c8e33b1527bfe2abaf92">
                        <div class="card h-100 border-0 shadow">
                            <div class="card-img-top overflow-hidden gradient-overlay"> <img class="img-fluid" src="img/photo/sample1.PNG" alt="Modern, Well-Appointed Room"/><a class="tile-link" href="detail-rooms.html"></a>
                                <div class="card-img-overlay-bottom z-index-20">
                                    <div class="d-flex text-white text-sm align-items-center"><img class="avatar avatar-border-white flex-shrink-0 me-2" src="img/avatar/avatar-0.jpg" alt="Pamela"/>
                                        <div>Pamela</div>
                                    </div>
                                </div>
                                <div class="card-img-overlay-top text-end"><a class="card-fav-icon position-relative z-index-40" href="javascript: void();">
                                    <svg class="svg-icon text-white">
                                        <use xlink:href="#heart-1"> </use>
                                    </svg></a></div>
                            </div>
                            <div class="card-body d-flex align-items-center">
                                <div class="w-100">
                                    <h6 class="card-title"><a class="text-decoration-none text-dark" href="detail-rooms.html">Modern, Well-Appointed Room</a></h6>
                                    <div class="d-flex card-subtitle mb-3">
                                        <p class="flex-grow-1 mb-0 text-muted text-sm">Private room</p>
                                        <p class="flex-shrink-1 mb-0 card-stars text-xs text-end"><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i>
                                        </p>
                                    </div>
                                    <p class="card-text text-muted"><span class="h4 text-primary">$80</span> per night</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide h-auto px-2" >
                    <!-- place item-->
                    <div class="w-100 h-100 hover-animate" data-marker-id="59c0c8e322f3375db4d89128">
                        <div class="card h-100 border-0 shadow">
                            <div class="card-img-top overflow-hidden gradient-overlay"> <img class="img-fluid" src="img/photo/sample1.PNG" alt="Cute Quirky Garden apt, NYC adjacent"/><a class="tile-link" href="detail-rooms.html"></a>
                                <div class="card-img-overlay-bottom z-index-20">
                                    <div class="d-flex text-white text-sm align-items-center"><img class="avatar avatar-border-white flex-shrink-0 me-2" src="img/avatar/avatar-7.jpg" alt="John"/>
                                        <div>John</div>
                                    </div>
                                </div>
                                <div class="card-img-overlay-top text-end"><a class="card-fav-icon position-relative z-index-40" href="javascript: void();">
                                    <svg class="svg-icon text-white">
                                        <use xlink:href="#heart-1"> </use>
                                    </svg></a></div>
                            </div>
                            <div class="card-body d-flex align-items-center">
                                <div class="w-100">
                                    <h6 class="card-title"><a class="text-decoration-none text-dark" href="detail-rooms.html">Cute Quirky Garden apt, NYC adjacent</a></h6>
                                    <div class="d-flex card-subtitle mb-3">
                                        <p class="flex-grow-1 mb-0 text-muted text-sm">Entire apartment</p>
                                        <p class="flex-shrink-1 mb-0 card-stars text-xs text-end"><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-gray-300">                                  </i>
                                        </p>
                                    </div>
                                    <p class="card-text text-muted"><span class="h4 text-primary">$121</span> per night</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide h-auto px-2" >
                    <!-- place item-->
                    <div class="w-100 h-100 hover-animate" data-marker-id="59c0c8e3a31e62979bf147c9">
                        <div class="card h-100 border-0 shadow">
                            <div class="card-img-top overflow-hidden gradient-overlay"> <img class="img-fluid" src="img/photo/photo-1512917774080-9991f1c4c750.jpg" alt="Modern Apt - Vibrant Neighborhood!"/><a class="tile-link" href="detail-rooms.html"></a>
                                <div class="card-img-overlay-bottom z-index-20">
                                    <div class="d-flex text-white text-sm align-items-center"><img class="avatar avatar-border-white flex-shrink-0 me-2" src="img/avatar/avatar-8.jpg" alt="Julie"/>
                                        <div>Julie</div>
                                    </div>
                                </div>
                                <div class="card-img-overlay-top text-end"><a class="card-fav-icon position-relative z-index-40" href="javascript: void();">
                                    <svg class="svg-icon text-white">
                                        <use xlink:href="#heart-1"> </use>
                                    </svg></a></div>
                            </div>
                            <div class="card-body d-flex align-items-center">
                                <div class="w-100">
                                    <h6 class="card-title"><a class="text-decoration-none text-dark" href="detail-rooms.html">Modern Apt - Vibrant Neighborhood!</a></h6>
                                    <div class="d-flex card-subtitle mb-3">
                                        <p class="flex-grow-1 mb-0 text-muted text-sm">Entire apartment</p>
                                        <p class="flex-shrink-1 mb-0 card-stars text-xs text-end"><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-gray-300">                                  </i><i class="fa fa-star text-gray-300">                                  </i>
                                        </p>
                                    </div>
                                    <p class="card-text text-muted"><span class="h4 text-primary">$75</span> per night</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide h-auto px-2" >
                    <!-- place item-->
                    <div class="w-100 h-100 hover-animate" data-marker-id="59c0c8e3503eb77d487e8082">
                        <div class="card h-100 border-0 shadow">
                            <div class="card-img-top overflow-hidden gradient-overlay"> <img class="img-fluid" src="img/photo/photo-1494526585095-c41746248156.jpg" alt="Sunny Private Studio-Apartment"/><a class="tile-link" href="detail-rooms.html"></a>
                                <div class="card-img-overlay-bottom z-index-20">
                                    <div class="d-flex text-white text-sm align-items-center"><img class="avatar avatar-border-white flex-shrink-0 me-2" src="img/avatar/avatar-9.jpg" alt="Barbora"/>
                                        <div>Barbora</div>
                                    </div>
                                </div>
                                <div class="card-img-overlay-top text-end"><a class="card-fav-icon position-relative z-index-40" href="javascript: void();">
                                    <svg class="svg-icon text-white">
                                        <use xlink:href="#heart-1"> </use>
                                    </svg></a></div>
                            </div>
                            <div class="card-body d-flex align-items-center">
                                <div class="w-100">
                                    <h6 class="card-title"><a class="text-decoration-none text-dark" href="detail-rooms.html">Sunny Private Studio-Apartment</a></h6>
                                    <div class="d-flex card-subtitle mb-3">
                                        <p class="flex-grow-1 mb-0 text-muted text-sm">Shared room</p>
                                        <p class="flex-shrink-1 mb-0 card-stars text-xs text-end"><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-gray-300">                                  </i>
                                        </p>
                                    </div>
                                    <p class="card-text text-muted"><span class="h4 text-primary">$93</span> per night</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide h-auto px-2" >
                    <!-- place item-->
                    <div class="w-100 h-100 hover-animate" data-marker-id="59c0c8e39aa2eed0626e485d">
                        <div class="card h-100 border-0 shadow">
                            <div class="card-img-top overflow-hidden gradient-overlay"> <img class="img-fluid" src="img/photo/photo-1522771739844-6a9f6d5f14af.jpg" alt="Mid-Century Modern Garden Paradise"/><a class="tile-link" href="detail-rooms.html"></a>
                                <div class="card-img-overlay-bottom z-index-20">
                                    <div class="d-flex text-white text-sm align-items-center"><img class="avatar avatar-border-white flex-shrink-0 me-2" src="img/avatar/avatar-10.jpg" alt="Jack"/>
                                        <div>Jack</div>
                                    </div>
                                </div>
                                <div class="card-img-overlay-top text-end"><a class="card-fav-icon position-relative z-index-40" href="javascript: void();">
                                    <svg class="svg-icon text-white">
                                        <use xlink:href="#heart-1"> </use>
                                    </svg></a></div>
                            </div>
                            <div class="card-body d-flex align-items-center">
                                <div class="w-100">
                                    <h6 class="card-title"><a class="text-decoration-none text-dark" href="detail-rooms.html">Mid-Century Modern Garden Paradise</a></h6>
                                    <div class="d-flex card-subtitle mb-3">
                                        <p class="flex-grow-1 mb-0 text-muted text-sm">Entire house</p>
                                        <p class="flex-shrink-1 mb-0 card-stars text-xs text-end"><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i>
                                        </p>
                                    </div>
                                    <p class="card-text text-muted"><span class="h4 text-primary">$115</span> per night</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="swiper-slide h-auto px-2" >
                    <!-- place item-->
                    <div class="w-100 h-100 hover-animate" data-marker-id="59c0c8e39aa2edasd626e485d">
                        <div class="card h-100 border-0 shadow">
                            <div class="card-img-top overflow-hidden gradient-overlay"> <img class="img-fluid" src="img/photo/photo-1488805990569-3c9e1d76d51c.jpg" alt="Brooklyn Life, Easy to Manhattan"/><a class="tile-link" href="detail-rooms.html"></a>
                                <div class="card-img-overlay-bottom z-index-20">
                                    <div class="d-flex text-white text-sm align-items-center"><img class="avatar avatar-border-white flex-shrink-0 me-2" src="img/avatar/avatar-11.jpg" alt="Stuart"/>
                                        <div>Stuart</div>
                                    </div>
                                </div>
                                <div class="card-img-overlay-top text-end"><a class="card-fav-icon position-relative z-index-40" href="javascript: void();">
                                    <svg class="svg-icon text-white">
                                        <use xlink:href="#heart-1"> </use>
                                    </svg></a></div>
                            </div>
                            <div class="card-body d-flex align-items-center">
                                <div class="w-100">
                                    <h6 class="card-title"><a class="text-decoration-none text-dark" href="detail-rooms.html">Brooklyn Life, Easy to Manhattan</a></h6>
                                    <div class="d-flex card-subtitle mb-3">
                                        <p class="flex-grow-1 mb-0 text-muted text-sm">Private room</p>
                                        <p class="flex-shrink-1 mb-0 card-stars text-xs text-end"><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-warning"></i><i class="fa fa-star text-gray-300">                                  </i>
                                        </p>
                                    </div>
                                    <p class="card-text text-muted"><span class="h4 text-primary">$123</span> per night</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- If we need pagination-->
            <div class="swiper-pagination"></div>
        </div>
    </div>
</div>
<!-- Footer-->
<footer class="position-relative z-index-10 d-print-none">
    <!-- Main block - menus, subscribe form-->
    <div class="py-6 bg-gray-200 text-muted">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 mb-5 mb-lg-0">
                    <div class="fw-bold text-uppercase text-dark mb-3">Directory</div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing.</p>
                    <ul class="list-inline">
                        <li class="list-inline-item"><a class="text-muted text-primary-hover" href="#" target="_blank" title="twitter"><i class="fab fa-twitter"></i></a></li>
                        <li class="list-inline-item"><a class="text-muted text-primary-hover" href="#" target="_blank" title="facebook"><i class="fab fa-facebook"></i></a></li>
                        <li class="list-inline-item"><a class="text-muted text-primary-hover" href="#" target="_blank" title="instagram"><i class="fab fa-instagram"></i></a></li>
                        <li class="list-inline-item"><a class="text-muted text-primary-hover" href="#" target="_blank" title="pinterest"><i class="fab fa-pinterest"></i></a></li>
                        <li class="list-inline-item"><a class="text-muted text-primary-hover" href="#" target="_blank" title="vimeo"><i class="fab fa-vimeo"></i></a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-6 mb-5 mb-lg-0">
                    <h6 class="text-uppercase text-dark mb-3">Rentals</h6>
                    <ul class="list-unstyled">
                        <li><a class="text-muted" href="index.html">Rooms</a></li>
                        <li><a class="text-muted" href="category-rooms.html">Map on top</a></li>
                        <li><a class="text-muted" href="category-2-rooms.html">Side map</a></li>
                        <li><a class="text-muted" href="category-3-rooms.html">No map</a></li>
                        <li><a class="text-muted" href="detail-rooms.html">Room detail</a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-6 mb-5 mb-lg-0">
                    <h6 class="text-uppercase text-dark mb-3">Pages</h6>
                    <ul class="list-unstyled">
                        <li><a class="text-muted" href="compare.html">Comparison                                   </a></li>
                        <li><a class="text-muted" href="team.html">Team                                   </a></li>
                        <li><a class="text-muted" href="contact.html">Contact                                   </a></li>
                    </ul>
                </div>
                <div class="col-lg-4">
                    <h6 class="text-uppercase text-dark mb-3">Daily Offers & Discounts</h6>
                    <p class="mb-3"> Lorem ipsum dolor sit amet, consectetur adipisicing elit. At itaque temporibus.</p>
                    <form action="#" id="newsletter-form">
                        <div class="input-group mb-3">
                            <input class="form-control bg-transparent border-dark border-end-0" type="email" placeholder="Your Email Address" aria-label="Your Email Address">
                            <button class="btn btn-outline-dark border-start-0" type="submit"> <i class="fa fa-paper-plane text-lg"></i></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Copyright section of the footer-->
    <div class="py-4 fw-light bg-gray-800 text-gray-300">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-6 text-center text-md-start">
                    <p class="text-sm mb-md-0">&copy; 2021, Your company.  All rights reserved.</p>
                </div>
                <div class="col-md-6">
                    <ul class="list-inline mb-0 mt-2 mt-md-0 text-center text-md-end">
                        <li class="list-inline-item"><img class="w-2rem" src="img/visa.svg" alt="..."></li>
                        <li class="list-inline-item"><img class="w-2rem" src="img/mastercard.svg" alt="..."></li>
                        <li class="list-inline-item"><img class="w-2rem" src="img/paypal.svg" alt="..."></li>
                        <li class="list-inline-item"><img class="w-2rem" src="img/western-union.svg" alt="..."></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- JavaScript files-->
<script>
    // ------------------------------------------------------- //
    //   Inject SVG Sprite -
    //   see more here
    //   https://css-tricks.com/ajaxing-svg-sprite/
    // ------------------------------------------------------ //
    function injectSvgSprite(path) {

        var ajax = new XMLHttpRequest();
        ajax.open("GET", path, true);
        ajax.send();
        ajax.onload = function(e) {
            var div = document.createElement("div");
            div.className = 'd-none';
            div.innerHTML = ajax.responseText;
            document.body.insertBefore(div, document.body.childNodes[0]);
        }
    }
    // to avoid CORS issues when viewing using file:// protocol, using the demo URL for the SVG sprite
    // use your own URL in production, please :)
    // https://demo.bootstrapious.com/directory/1-0/icons/orion-svg-sprite.svg
    //- injectSvgSprite('${path}icons/orion-svg-sprite.svg');
    injectSvgSprite('https://demo.bootstrapious.com/directory/1-4/icons/orion-svg-sprite.svg');

</script>
<!-- jQuery-->
<script src="vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap JS bundle - Bootstrap + PopperJS-->
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Magnific Popup - Lightbox for the gallery-->
<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
<!-- Smooth scroll-->
<script src="vendor/smooth-scroll/smooth-scroll.polyfills.min.js"></script>
<!-- Bootstrap Select-->
<script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
<!-- Object Fit Images - Fallback for browsers that don't support object-fit-->
<script src="vendor/object-fit-images/ofi.min.js"></script>
<!-- Swiper Carousel                       -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/js/swiper.min.js"></script>
<script>var basePath = ''</script>
<!-- Main Theme JS file    -->
<script src="js/theme.js"></script>
<script defer src="js/custom.js"></script>
<!-- Map-->
<script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og==" crossorigin=""></script>
<!-- Available tile layers-->
<script src="js/map-layers.js"> </script>
<script src="js/map-detail.js"></script>
<script>
    createDetailMap({
        mapId: 'detailMap',
        mapZoom: 14,
        mapCenter: [40.732346, -74.0014247],
        circleShow: true,
        circlePosition: [40.732346, -74.0014247]
    })

</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"> </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-date-range-picker/0.19.0/jquery.daterangepicker.min.js"> </script>
<script src="js/datepicker-detail.js">   </script>
</body>