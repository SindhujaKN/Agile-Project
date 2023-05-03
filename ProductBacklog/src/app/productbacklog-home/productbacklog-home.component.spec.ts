import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductbacklogHomeComponent } from './productbacklog-home.component';

describe('ProductbacklogHomeComponent', () => {
  let component: ProductbacklogHomeComponent;
  let fixture: ComponentFixture<ProductbacklogHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductbacklogHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductbacklogHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
