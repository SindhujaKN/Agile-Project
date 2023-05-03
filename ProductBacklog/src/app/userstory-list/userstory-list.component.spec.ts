import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserstoryListComponent } from './userstory-list.component';

describe('UserstoryListComponent', () => {
  let component: UserstoryListComponent;
  let fixture: ComponentFixture<UserstoryListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserstoryListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserstoryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
