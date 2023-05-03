import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserstoryDetilShowComponent } from './userstory-detil-show.component';

describe('UserstoryDetilShowComponent', () => {
  let component: UserstoryDetilShowComponent;
  let fixture: ComponentFixture<UserstoryDetilShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserstoryDetilShowComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserstoryDetilShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
