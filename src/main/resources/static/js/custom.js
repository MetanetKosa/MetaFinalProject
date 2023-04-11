

// 브라우저에 화면이 나왔을 때
window.addEventListener("DOMContentLoaded",()=>{

    const setNavigationPosition = () =>{
        const detailBar = document.getElementById("detailBar")
        if(window.scrollY>890){
            detailBar.classList.add("fixed-top")
        }else{
            detailBar.classList.remove("fixed-top")
        }
    }

    setInterval(()=>{
        setNavigationPosition();
    },500);



    const swiper = new Swiper('.swiper', {
        // slidesPerGroup: 4,
        slidesPerView: 4,
        spaceBetween: 10,
        // Responsive breakpoints
        // breakpoints: {
        //     // when window width is >= 320px
        //     320: {
        //         slidesPerView: 2,
        //         spaceBetween: 20
        //     },
        //     // when window width is >= 480px
        //     480: {
        //         slidesPerView: 3,
        //         spaceBetween: 30
        //     },
        //     // when window width is >= 640px
        //     640: {
        //         slidesPerView: 4,
        //         spaceBetween: 40
        //     }
        // }
        autoplay: {
            delay: 3000,
        },
        loop:true,
        speed: 400,
        // spaceBetween: 100,
        stopOnLastSlide:true,
        // pagination: {
        //     el: '.swiper-pagination',
        //     type: 'bullets',
        // },
    });

    // const changeTextColor = (clickedItem) =>{
    //     document.querySelectorAll("detail-bar-item").forEach((element,index)=>{
    //         console.log("1")
    //         if(Number(clickedItem.dataset.index)===Number(index)){
    //             element.classList.add("clicked");
    //             console.log("2")
    //         }else{
    //             element.classList.remove("clicked");
    //             console.log("3")
    //         }
    //     })
    // }
})

// 네비게이션 클릭했을 때 클릭된 항목 색상 변경
const changeTextColor = (clickedItem) =>{
    // detail-bar-item 이라는 클래스를 가진 span을 선택 >
    document.querySelectorAll(".detail-bar-item").forEach((element,index)=>{
        if(Number(clickedItem.dataset.index)===Number(index)){
            element.classList.add("clicked");
        }else{
            element.classList.remove("clicked");
        }
    })
}




