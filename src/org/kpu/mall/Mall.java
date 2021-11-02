package org.kpu.mall;

interface Mall {
	public abstract void displayItem( ); // 상품 전시
	public abstract void buyItem( ); // 제품 구매 - 카트에 저장
	public abstract void showReceipt( ) ; // 구매 영수증 출력
}
