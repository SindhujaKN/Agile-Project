import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserstoryListShowComponent } from './userstory-list-show.component';

describe('UserstoryListShowComponent', () => {
  let component: UserstoryListShowComponent;
  let fixture: ComponentFixture<UserstoryListShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserstoryListShowComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserstoryListShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
